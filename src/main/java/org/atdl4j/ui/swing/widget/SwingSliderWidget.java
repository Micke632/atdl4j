package org.atdl4j.ui.swing.widget;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.swing.*;

import org.atdl4j.fixatdl.core.EnumPairT;
import org.atdl4j.fixatdl.layout.ListItemT;
import org.atdl4j.fixatdl.layout.SliderT;
import org.atdl4j.ui.impl.ControlHelper;
import org.atdl4j.ui.swing.SwingListener;

public class SwingSliderWidget
		extends AbstractSwingWidget<String>
{
	private JSlider slider;
	private JLabel label;

	public String getControlValueRaw()
	{
		return ( (SliderT) control ).getListItem().get( slider.getValue() ).getEnumID();
	}

	@Override
	public String getParameterValue()
	{
		return getParameterValueAsEnumWireValue();
	}

	public void setValue(String value)
	{
		this.setValue( value, false );
	}

	public void setValue(String value, boolean setValueAsControl)
	{
		for ( int i = 0; i < getListItems().size(); i++ )
		{
			if ( setValueAsControl || parameter == null )
			{
				if ( getListItems().get( i ).getEnumID().equals( value ) )
				{
					slider.setValue( i );
					break;
				}
			}
			else
			{
				if ( parameter.getEnumPair().get( i ).getWireValue().equals( value ) )
				{
					slider.setValue( i );
					break;
				}
			}
		}
	}
	
	public List<Component> getComponents() {
		List<Component> widgets = new ArrayList<>();
		widgets.add(label);
		widgets.add(slider);
		return widgets;
	}

	public List<Component> getComponentsExcludingLabel()
	{
		List<Component> widgets = new ArrayList<>();
		widgets.add(slider);
		return widgets;
	}

	@Override
	public void addListener(SwingListener listener) {
		slider.addChangeListener(listener);
	}

	@Override
	public void removeListener(SwingListener listener) {
		slider.removeChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see org.atdl4j.ui.ControlUI#reinit()
	 */
	@Override
	public void processReinit( Object aControlInitValue )
	{
		if ( ( slider != null ) )
		{
			if ( aControlInitValue != null )
			{
				// -- apply initValue if one has been specified --
				setValue( (String) aControlInitValue, true );
			}
			else
			{
				// -- set to minimum when no initValue exists --
				slider.setValue( slider.getMinimum() );
			}
		}
	}

	/* 
	 * 
	 */
	protected void processNullValueIndicatorChange(Boolean aOldNullValueInd, Boolean aNewNullValueInd)
	{
	}
	
	@Override
	protected List< ? extends Component> createBrickComponents() {
	  List<Component> components = new ArrayList<>();
	  
	  //  label
      label = new JLabel();
      label.setName(getName()+"/label");
      if (control.getLabel() != null) label.setText(control.getLabel());
      
      int numColumns = ((SliderT)control).getListItem().size();

      // slider
		slider = new JSlider(SwingConstants.HORIZONTAL, 0, numColumns - 1, 0);
      slider.setName(getName()+"/slider");

      // add major tick marks
      slider.setMajorTickSpacing(1);
      slider.setPaintTicks(true);
      
      // labels based on parameter ListItemTs
		Dictionary<Integer, JLabel> labelTable = new Hashtable<>();
		int i = 0;
		for ( ListItemT li : ( (SliderT) control ).getListItem() )
		{
			JLabel tmpJLabel = new JLabel();
			tmpJLabel.setName(getName()+"/slider/"+li.getEnumID()+"/label");
			if (li.getUiRep() != null && !li.getUiRep().equals(""))
			{
				tmpJLabel.setText( li.getUiRep() );
			}
			for ( EnumPairT ep : parameter.getEnumPair() )
			{
				if (ep.getEnumID().equals(li.getEnumID()) && ep.getDescription() != null && !ep.getDescription().equals(""))
				{
					tmpJLabel.setToolTipText(ep.getDescription());
				}
			}
			labelTable.put(Integer.valueOf(i), tmpJLabel);
			i++;
		}
		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true);

      // tooltip
      if ( getTooltip() != null )
      {
          slider.setToolTipText( getTooltip() );
          if (label != null) label.setToolTipText( getTooltip() );
      }
      
      if ( ControlHelper.getInitValue( control, getAtdl4jOptions() ) != null )
      {
	      setValue((String) ControlHelper.getInitValue(control, getAtdl4jOptions()), true);
      }

      components.add(label);
      components.add(slider);
      
      return components;
	}
}
