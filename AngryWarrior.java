public class AngryWarrior extends Adventurer{
    private int rage;

    private String warcry;

    private int rageMax;
    public String getSpecialName(){
      return "Rage";
    }
    public int getSpecialMax(){
      return rageMax;
    }
    public int getSpecial(){
      return rage;
    }

    public int restoreSpecial(int amount){
      rage += amount;
      if(rage > rageMax)rage = rageMax;
      return rage;
    }

    //put in default name
    public AngryWarrior(){
	     this("Magnus");
    }

    //put in default warcry
    public AngryWarrior(String name){
	     this(name,"Valhalllaaaaa!!", 18);
    }

    //default health is 30-39 randomly
    public AngryWarrior(String name, String warcry, int rage){
      super(name,30+(int)(Math.random()*10));
      setWarcry(warcry);
      setRage(rage/2);
      setRageMax(rage);
    }


    public String attack(Adventurer other){
    	  int damage = (int)(Math.random()*10)+6;
  	    other.applyDamage(damage);
  	    setRage(getRage() + 2);
  	    return (this + " attacked "
           + other + " for " + damage + " damage!");
    }
    public String support(Adventurer other){
      return (this + " cheered " + other + "(But had no noticeable effect)");
    }

    public String specialAttack(Adventurer other){
	     if(getRage() >= 10){
  	        int damage = (int)(Math.random()*20)+1;
            other.applyDamage(damage);
            setRage(getRage() - 10);
            return(this + " unleashes his fury upon "
             + other + " for " + damage + " damage! "+warcry);
	    }else{
			    return("Not enough rage! "+attack(other));
	    }
    }

    //get methods
    public int getRage(){
	     return rage;
    }
    //set methods
    public void setRage(int r){
	     this.rage = r;
    }
    //set methods
    public void setRageMax(int r){
       this.rageMax = r;
    }
    public void setWarcry(String warcry){
	     this.warcry = warcry;
    }


}
