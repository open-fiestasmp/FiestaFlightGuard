package com.fiesta.flight;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class FlightGuard extends JavaPlugin implements Listener {
 @Override public void onEnable() {
  Bukkit.getPluginManager().registerEvents(this,this);
  Bukkit.getScheduler().runTaskTimer(this,()->{for(Player p:Bukkit.getOnlinePlayers())enforce(p);},1L,1L);
  getLogger().info("Survival flight protection enabled");
 }
 private void enforce(Player p){
  if(p.getGameMode()!=GameMode.SURVIVAL || !p.getAllowFlight())return;
  if(p.isFlying()&&!p.isOnGround()){
   PotionEffect current=p.getPotionEffect(PotionEffectType.SLOW_FALLING);
   if(current==null||current.getDuration()<7200)p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,7200,current==null?0:current.getAmplifier(),true,false,true));
   p.setFallDistance(0);
  }
  p.setFlying(false);p.setAllowFlight(false);
 }
 @EventHandler(priority=EventPriority.HIGHEST,ignoreCancelled=true)
 public void onFly(PlayerToggleFlightEvent e){if(e.isFlying()&&e.getPlayer().getGameMode()==GameMode.SURVIVAL)e.setCancelled(true);}
}
