package tk.cvrunmin.railwayp.client;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tk.cvrunmin.railwayp.CommonProxy;
import tk.cvrunmin.railwayp.client.renderer.TileEntityNameBannerRenderer;
import tk.cvrunmin.railwayp.client.renderer.TileEntityPFDoorRenderer;
import tk.cvrunmin.railwayp.client.renderer.TileEntityPlatformBannerRenderer;
import tk.cvrunmin.railwayp.client.renderer.TileEntityRouteSignageRenderer;
import tk.cvrunmin.railwayp.init.RPBlocks;
import tk.cvrunmin.railwayp.init.RPItems;
import tk.cvrunmin.railwayp.tileentity.TileEntityNameBanner;
import tk.cvrunmin.railwayp.tileentity.TileEntityPFDoor;
import tk.cvrunmin.railwayp.tileentity.TileEntityPlatformBanner;
import tk.cvrunmin.railwayp.tileentity.TileEntityRouteSignage;

public class ClientProxy extends CommonProxy{
	@Override
	public void init(FMLInitializationEvent event) {
//		blockRend(RPBlocks.platform_banner, "wall_platform_banner");
		itemRend(RPItems.platform_banner, "platform_banner");
		itemRend(RPItems.name_banner, "name_banner");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlatformBanner.class, new TileEntityPlatformBannerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNameBanner.class, new TileEntityNameBannerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRouteSignage.class, new TileEntityRouteSignageRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPFDoor.class, new TileEntityPFDoorRenderer());
	}
}
