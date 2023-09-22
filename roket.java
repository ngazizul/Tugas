import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class roket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class roket extends Actor
{
    /**
     * Act - do whatever the roket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(1);
        if (Greenfoot.getRandomNumber(10) < 1)
        {
            int randomAngle = Greenfoot.getRandomNumber(91) - 45;
            setRotation(getRotation() + randomAngle);
        }
        
        // Memeriksa apakah roket mencapai batas-batas yang diinginkan
        checkBounds();
        
        // Memeriksa apakah ada Cactus di depan Ladybugs
        checkForbalon();
    }
    
    // Memeriksa batasan dan menghindarinya
    private void checkBounds()
    {
        int x = getX();
        int y = getY();
        
        // Batas-batas yang diinginkan
        int minX = 25; // Batas kiri (600 - 550)
        int maxX = getWorld().getWidth() - 25; // Batas kanan (600 - 25)
        int minY = 25; // Batas atas (400 - 350)
        int maxY = getWorld().getHeight() - 25; // Batas bawah (400 - 25)
        
        if (x <= minX || x >= maxX || y <= minY || y >= maxY)
        {
            // Jika roket mencapai batasan, maka balik arah dengan tambahan random
            setRotation(getRotation() + 180 + Greenfoot.getRandomNumber(90) - 45);
        }
    }
    
    // Memeriksa apakah ada balon di depan roket
    private void checkForbalon()
    {
        Actor balon = getOneObjectAtOffset(0, 0, balon.class); // Mengecek apakah ada balon di lokasi yang sama dengan roket
        if (balon != null)
        {
            // Jika ada Cactus di depan roket, maka putar arahnya
            setRotation(getRotation() + 180 + Greenfoot.getRandomNumber(90) - 45);
        }
    }
}
