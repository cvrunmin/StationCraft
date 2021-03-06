package io.github.cvronmin.railwayp.tileentity;

import io.github.cvronmin.railwayp.RailwayP;
import io.github.cvronmin.railwayp.network.RPPacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRailNoticer extends TileEntity {
    public String thisStat;
    public String nextStat;
    public String interchange;
	@Override
	    public NBTTagCompound writeToNBT(NBTTagCompound compound)
	    {
	        super.writeToNBT(compound);
	        if(thisStat != "" && thisStat != null){
	            compound.setString("ThisStation", thisStat);
	        }
	        if(nextStat != "" && nextStat != null){
	            compound.setString("NextStation", nextStat);
	        }
	        if(interchange != "" && interchange != null){
	            compound.setString("InterChange", interchange);
	        }
			return compound;
	    }
		@Override
	    public void readFromNBT(NBTTagCompound compound)
	    {
	        super.readFromNBT(compound);
	        thisStat = compound.getString("ThisStation");
	        nextStat = compound.getString("NextStation");
	        interchange = compound.getString("Interchange");
	    }
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new SPacketUpdateTileEntity(this.pos, 6, nbttagcompound);
    }
    public boolean sendNotice(EntityPlayerMP player){
    	sendNotice(player, thisStat, RPPacket.EnumRPPacket.C_UPDATETHISSTATION);
    	sendNotice(player, nextStat, RPPacket.EnumRPPacket.C_UPDATENEXTSTATION);
    	sendNotice(player, interchange, RPPacket.EnumRPPacket.C_UPDATEINTERCHANGE);
	    return true;
    }
    private boolean isEmpty(String s){
    	return s == null || s == "";
    }
    private void sendNotice(EntityPlayerMP player, String s, RPPacket.EnumRPPacket type){
    	if(!isEmpty(s)){
    		RailwayP.channelHandle.sendTo(new RPPacket(type, new Object[]{s}), player);
    	}
    	else{
    		RailwayP.channelHandle.sendTo(new RPPacket(type, new Object[]{""}), player);	
    	}
    }
}
