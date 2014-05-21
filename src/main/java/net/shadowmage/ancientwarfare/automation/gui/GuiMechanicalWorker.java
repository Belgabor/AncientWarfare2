package net.shadowmage.ancientwarfare.automation.gui;

import net.minecraft.util.StatCollector;
import net.shadowmage.ancientwarfare.automation.container.ContainerMechanicalWorker;
import net.shadowmage.ancientwarfare.core.container.ContainerBase;
import net.shadowmage.ancientwarfare.core.gui.GuiContainerBase;
import net.shadowmage.ancientwarfare.core.gui.elements.CompositeScrolled;
import net.shadowmage.ancientwarfare.core.gui.elements.Label;
import net.shadowmage.ancientwarfare.core.gui.elements.ProgressBar;

public class GuiMechanicalWorker extends GuiContainerBase
{

Label energyLabel;

ProgressBar pg1;
ContainerMechanicalWorker container;

CompositeScrolled comp;

public GuiMechanicalWorker(ContainerBase par1Container)
  {
  super(par1Container, 178, ((ContainerMechanicalWorker)par1Container).guiHeight, defaultBackground);
  container = (ContainerMechanicalWorker)par1Container;
  }

@Override
public void initElements()
  {
  pg1 = new ProgressBar(8, 8, 178-16, 10);
  addGuiElement(pg1);
  
  energyLabel = new Label(8,8,StatCollector.translateToLocal("guistrings.automation.energy_stored")+": "+container.energy);
  addGuiElement(energyLabel);
  }

@Override
public void setupElements()
  {
  energyLabel.setText(StatCollector.translateToLocal("guistrings.automation.energy_stored")+": "+container.energy);
  float progress = 0;
  
  progress = (float)container.energy / (float)container.tile.getMaxEnergy();
  pg1.setProgress(progress);
  }

}