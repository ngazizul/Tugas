import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class burung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class burung extends Actor
{
    private double g = 1;
    private int y = 200;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacroos = false;
    private boolean hasaddscore = false;
    public burung(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }
    public void act()
    {
        //jika tekan spasi, koordinat y akan berkurang dan terbang ke atas 
        if(spacePressed()){
            g = -2; 
        }
        g += 0.1;//Nilai g meningkat 0,1 setiap saat 
        y += g;//Nilai y tidak berubah dengan kecepatan konstan 
        setLocation(getX(), (int)(y));
        //jika menabrak pipa maka burung mati
        if(isTouchpipa()){
            isalive = false;
        }
        //setelah jatuh atau menabrak pipa maka burung hilang
        if(!isalive){
            getWorld().addObject(new gameover(), 300, 200);
            getWorld().removeObject(this);
        }
        //penambahan skor setelah melewati pipa dan pemberian suara
        if(!hasaddscore && isacroos && isalive){
            Greenfoot.playSound("score.mp3");
            score.add(1);
        }
        hasaddscore = isacroos;
    }
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("Space")){
            if(!haspressed){//pemberian suara
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            haspressed = true;
        }else{
            haspressed =false;
        }
        return pressed;
    }
    //pemberian suara ketika menabrak pipa dan jatuh
    public boolean isTouchpipa(){
        isacroos = false;
        for(pipa pipa : getWorld().getObjects(pipa.class)){
            if(Math.abs(pipa.getX() - getX()) < 69){
            if(Math.abs(pipa.getY() + 30 - getY()) > 37){
                Greenfoot.playSound("peng.mp3");
                isalive = false;
            }
            isacroos = true;
        }
    }
    return !isalive;
}
}
