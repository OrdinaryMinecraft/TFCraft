package com.bioxx.tfc.Render.Models;

import net.minecraft.client.model.ModelBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelIngotPile extends ModelBase
{
	public ModelRendererTFC[] renderer = new ModelRendererTFC[64];
	int ingotHeight = 4;
	int ingotWidth = 7;
	int ingotDepth = 15;

	public ModelIngotPile()
	{
		for (int n = 0; n < 64; n++){
			this.renderer[n] = new ModelRendererTFC(this,0,0);
			int m = (n+8)/8;
			float x = (n %4)*8f;
			float y = (m -1)*4f;
			float z = 0;


			if (n%8 >=4){
				z = 16f;
			}
			if (m %2 == 1)
			{
				renderer[n].cubeList.add(
						new ModelIngot(renderer[n],renderer[n].textureOffsetX, renderer[n].textureOffsetY, 0.5F + x, y, z + 0.5f, ingotWidth, ingotHeight, ingotDepth, 0f));

				/*Object[] dataArray = new Object[10];
				dataArray[0] = new float[] {0,0,0,8,0,8,8};
				dataArray[9] = new float[] {0,0,0,8,1,8,5};
				dataArray[1] = new float[] {0,0,0,8,4,8,13};
				dataArray[8] = new float[] {0,0,0,8,4,8,9};
				dataArray[2] = new float[] {0,0,0,8,11,8,12};
				dataArray[7] = new float[] {0,0,0,8,11,8,9};
				dataArray[3] = new float[] {0,0,0,8,13,8,8};
				dataArray[6] = new float[] {0,0,0,8,13,8,5};
				dataArray[4] = new float[] {0,0,0,8,15,8,8};
				dataArray[5] = new float[] {0,0,0,8,15,8,5};
				renderer[n].cubeList.add(new ModelPotteryBase(renderer[n],renderer[n].textureOffsetX, renderer[n].textureOffsetY, 0.5F + x, y, z + 0.5f, ingotWidth, ingotHeight, ingotDepth, 0f,dataArray,true));*/
			}
			else
			{
				renderer[n].cubeList.add(
						new ModelIngot(renderer[n],renderer[n].textureOffsetX, renderer[n].textureOffsetY, z + 0.5f, y, 0.5f + x, ingotDepth, ingotHeight, ingotWidth, 0f));
				
			}
		}
	}

	public void renderIngots(int i)
	{
		for (int n = 0; n < i; n++)
		{
			renderer[n].render(0.0625F / 2F);
		}
	}
}
