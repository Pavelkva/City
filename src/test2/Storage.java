package test2;

import java.util.ArrayList;
import java.util.List;

public class Storage {

  List<Npc> allNpcs;
  List<Location> allLocations;

  public Storage() {
    
    allNpcs = new ArrayList<Npc>();
    
  }
  
  public Npc getNpc(int id) {
    for (Npc npc : allNpcs) {
      if(npc.getId() == id) {
        return npc;
      }
    }
    return null;    
  }

  public void addNpc(Npc npc) {
  
    allNpcs.add(npc);
    
  }
  
   public Location getLocation(int id) {
    for (Location location : allLocations) {
      if(location.getId() == id) {
        return location;
      }
    }
    return null;    
  }
   
  public void addLocation(Location location) {
  
    allLocations.add(location);
    
  }
  
}
