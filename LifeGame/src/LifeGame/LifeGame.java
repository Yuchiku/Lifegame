package LifeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class LifeGame extends JFrame
{
	private final World world;
	
	public LifeGame(int rows, int columns)
	{
		world = new World(rows, columns);
		new Thread(world).start();
		add(world);
	}
	
    public static void main(String[] args) 
    {
    	LifeGame frame = new LifeGame(40, 50);
    	
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        
        JMenu options = new JMenu("Options");
        menu.add(options);
        
        JMenuItem heart=options.add("Heart");
        heart.addActionListener(frame.new  HeartActionListener());
        
        JMenuItem wish = options.add("Wish");
        wish.addActionListener(frame.new WishActionListener());
        
        JMenuItem justwe = options.add("Justwe");
        justwe.addActionListener(frame.new JustweActionListener());   
        
        JMenu help = new JMenu("Help");        
        menu.add(help);
        
        
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 859);
        frame.setTitle("Game of Life");
        frame.setVisible(true);
        frame.setResizable(false);
    }	
    
    class WishActionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setWish();
    	}
    }
    
    class JustweActionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setSquare();
    	}
    }    
    
    class HeartActionListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setHeart();
    	}
    }    
}
