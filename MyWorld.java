import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int score = 0;
    private SimpleTimer timer = new SimpleTimer();
    private Counter timeCount = new Counter();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 650, 1);
        this.score=0;
        addObject(timeCount, 300, 25);
        timeCount.setValue(60);
        prepare();
    }
    
    public void act(){
        showText("Score = "+ score , 50, 25);
        
        if(score >= 3){
            addObject(new Home(),575,25);
        }
        
        if (timer.millisElapsed() > 1000) {
            timeCount.add(-1);
            timer.mark();
        }
   
        if (timeCount.getValue() == 0) {
            showText("Je hebt verloren" , 400, 25);
            Greenfoot.stop();
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    private void prepare()
    {   
        int y = 75;
        int x = 25;        
        int[][] maze = 
            {
                {1, 1, 1, 1, 0, 2, 1, 0, 0, 0, 1, 0},
                {Greenfoot.getRandomNumber(2)+2, 0, 0, 1, 0, 1, 1, 0, 1, Greenfoot.getRandomNumber(2)+2, 1, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {Greenfoot.getRandomNumber(2)+2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1, 0, 1, 2, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 0, Greenfoot.getRandomNumber(2)+2, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, Greenfoot.getRandomNumber(2)+2},
                {Greenfoot.getRandomNumber(2)+2, 1, 0, 1, 0, 1, 1, 0, 0, 1, Greenfoot.getRandomNumber(2)+2, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, Greenfoot.getRandomNumber(2)+2, 0, Greenfoot.getRandomNumber(2)+2, 1, 0, 0, 0, 0, 0},

            };
        for(int i=0; i<maze.length; i++) {
            x = 25;
            for(int j=0; j<maze[i].length; j++) {  
                if(maze[i][j] == 1){
                    addObject(new Wall(),x,y);
                }
                else if(maze[i][j] == 2){
                    addObject(new Food(),x,y);
                }  
                else if(maze[i][j] == 3){
                    addObject(new Enemy(),x,y);
                }  
                x = x+50;
            }
            y= y+50;
        }

        addObject(new Person(),25,625);

    }
  
}
