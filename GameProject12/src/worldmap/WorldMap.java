/*
 * World map class
 * Author: Utku Bilgin
 * Version: 12/05/2018
 */
package worldmap;

import javax.swing.ImageIcon;
import level.properties.LevelProperties;

/**
 * WorldMap class
 * @author MadeByHumans
 * @version 11.05.2018
 */
public class WorldMap extends javax.swing.JFrame 
{
    //Properties
	
	 // Variables declaration
    private javax.swing.JButton westButton;
    private javax.swing.JButton chicButton;
    private javax.swing.JButton forbidButton;
    private javax.swing.JButton tableButton;
    private javax.swing.JButton waikikiButton;
    private javax.swing.JButton hagiaButton;
    private javax.swing.JButton sydneyButton;
    private javax.swing.JLabel westLabel1;
    private javax.swing.JLabel hagiaLabel2;
    private javax.swing.JLabel tableLabel2;
    private javax.swing.JLabel sydneyLabel2;
    private javax.swing.JLabel forbidLabel2;
    private javax.swing.JLabel waikikiLabel2;
    private javax.swing.JLabel chicLabel2;
    private javax.swing.JLabel mapLabel;
    private javax.swing.JLabel westLabel2;
    private javax.swing.JLabel forbidLabel1;
    private javax.swing.JLabel tableLabel1;
    private javax.swing.JLabel chicLabel1;
    private javax.swing.JLabel sydneyLabel1;
    private javax.swing.JLabel hagiaLabel1;
    private javax.swing.JLabel waikikiLabel1;
    public String nameOfTheCity;

    //Constructors
    /**
     * Creates new form map
     */
    public WorldMap() 
    {
        this.setSize(800, 600);
        this.setResizable(false);
        initComponents();
    }
    //Methods

    /*initComponents method
    This method intializes the components. */
    private void initComponents() 
    {

        forbidButton = new javax.swing.JButton();
        tableButton = new javax.swing.JButton();
        waikikiButton = new javax.swing.JButton();
        hagiaButton = new javax.swing.JButton();
        sydneyButton = new javax.swing.JButton();
        westLabel1 = new javax.swing.JLabel();
        forbidLabel1 = new javax.swing.JLabel();
        tableLabel1 = new javax.swing.JLabel();
        sydneyLabel1 = new javax.swing.JLabel();
        hagiaLabel1 = new javax.swing.JLabel();
        waikikiLabel1 = new javax.swing.JLabel();
        hagiaLabel2 = new javax.swing.JLabel();
        tableLabel2 = new javax.swing.JLabel();
        sydneyLabel2 = new javax.swing.JLabel();
        forbidLabel2 = new javax.swing.JLabel();
        waikikiLabel2 = new javax.swing.JLabel();
        westButton = new javax.swing.JButton();
        westLabel2 = new javax.swing.JLabel();
        chicLabel1 = new javax.swing.JLabel();
        chicLabel2 = new javax.swing.JLabel();
        chicButton = new javax.swing.JButton();
        mapLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        forbidButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseEntered method
             * @param Mouseevent evt
             */
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                jButton3MouseEntered(evt);
            }

            /*mouseExited method
             * @param Mouseevent evt
             */
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                jButton3MouseExited(evt);
            }
        });

        forbidButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param Mouseevent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton3ActionPerformed(evt);
            }
        });

        tableButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseEntered method
             * @param Mouseevent evt
             */
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jButton4MouseEntered(evt);
            }

            /*mouseExited method
             * @param Mouseevent evt
             */
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                jButton4MouseExited(evt);
            }
        });

        tableButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param Mouseevent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        waikikiButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseEntered method
             * @param Mouseevent evt
             */
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jButton5MouseEntered(evt);
            }

            /*mouseExited method
             * @param Mouseevent evt
             */
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                jButton5MouseExited(evt);
            }
        });

        waikikiButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param Mouseevent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton5ActionPerformed(evt);
            }
        });

        hagiaButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseEntered method
             * @param Mouseevent evt
             */
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                jButton6MouseEntered(evt);
            }

            /*mouseExited method
             * @param Mouseevent evt
             */
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                jButton6MouseExited(evt);
            }
        });

        hagiaButton.addActionListener(new java.awt.event.ActionListener()
        {
            /*actionPerformed method
             * @param Mouseevent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton6ActionPerformed(evt);
            }
        });

        sydneyButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseEntered method
             * @param Mouseevent evt
             */
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                jButton7MouseEntered(evt);
            }

            /*mouseExited method
             * @param Mouseevent evt
             */
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                jButton7MouseExited(evt);
            }
        });

        sydneyButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param Mouseevent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton7ActionPerformed(evt);
            }
        });

        westButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseEntered method
             * @param Mouseevent evt
             */
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                jButton1MouseEntered(evt);
            }

            /*mouseExited method
             * @param Mouseevent evt
             */
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                jButton1MouseExited(evt);
            }
        });

        westButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param Mouseevent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton1ActionPerformed(evt);
            }
        });

        chicButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseEntered method
             * @param Mouseevent evt
             */
            public void mouseEntered(java.awt.event.MouseEvent evt) 
            {
                jButton2MouseEntered(evt);
            }

            /*mouseExited method
             * @param Mouseevent evt
             */
            public void mouseExited(java.awt.event.MouseEvent evt) 
            {
                jButton2MouseExited(evt);
            }
        });

        chicButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param Mouseevent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton2ActionPerformed(evt);
            }
        });

        westLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/worldmap/Untitled.png")));
        getContentPane().add(westLabel1);
        westLabel1.setBounds(540, 20, 130, 70);

        forbidLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soccer.png")));
        getContentPane().add(forbidLabel1);
        forbidLabel1.setBounds(880, 80, 130, 70);

        tableLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soccer.png")));
        getContentPane().add(tableLabel1);
        tableLabel1.setBounds(650, 310, 90, 60);

        sydneyLabel1.setFont(new java.awt.Font("Utsaah", 0, 18));
        sydneyLabel1.setForeground(new java.awt.Color(240, 240, 240));
        sydneyLabel1.setText("SYDNEY");
        getContentPane().add(sydneyLabel1);
        sydneyLabel1.setBounds(970, 330, 100, 40);

        hagiaLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soccer.png")));
        getContentPane().add(hagiaLabel1);
        hagiaLabel1.setBounds(680, 73, 110, 60);

        waikikiLabel1.setFont(new java.awt.Font("Utsaah", 0, 18));
        waikikiLabel1.setForeground(new java.awt.Color(240, 240, 240));
        waikikiLabel1.setText("WAIKIKI BEACH");
        getContentPane().add(waikikiLabel1);
        waikikiLabel1.setBounds(60, 190, 200, 24);

        hagiaLabel2.setFont(new java.awt.Font("Utsaah", 0, 18));
        hagiaLabel2.setForeground(new java.awt.Color(240, 240, 240));
        hagiaLabel2.setText("HAGIA SOPHIA");
        getContentPane().add(hagiaLabel2);
        hagiaLabel2.setBounds(670, 130, 180, 40);

        tableLabel2.setFont(new java.awt.Font("Utsaah", 0, 18));
        tableLabel2.setForeground(new java.awt.Color(240, 240, 240));
        tableLabel2.setText("TABLE MOUNTAIN");
        tableLabel2.setMaximumSize(new java.awt.Dimension(20, 20));
        tableLabel2.setMinimumSize(new java.awt.Dimension(30, 30));
        tableLabel2.setPreferredSize(new java.awt.Dimension(20, 30));
        getContentPane().add(tableLabel2);
        tableLabel2.setBounds(630, 360, 200, 40);

        sydneyLabel2.setFont(new java.awt.Font("Utsaah", 0, 18));
        sydneyLabel2.setForeground(new java.awt.Color(240, 240, 240));
        sydneyLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soccer.png")));
        getContentPane().add(sydneyLabel2);
        sydneyLabel2.setBounds(960, 270, 100, 70);

        forbidLabel2.setFont(new java.awt.Font("Utsaah", 0, 18));
        forbidLabel2.setForeground(new java.awt.Color(240, 240, 240));
        forbidLabel2.setText("FORBIDDEN CITY");
        getContentPane().add(forbidLabel2);
        forbidLabel2.setBounds(870, 150, 200, 24);

        waikikiLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soccer.png")));
        getContentPane().add(waikikiLabel2);
        waikikiLabel2.setBounds(70, 120, 130, 70);

        westButton.setOpaque(false);
        westButton.setContentAreaFilled(false);
        westButton.setBorderPainted(false);
        getContentPane().add(westButton);
        westButton.setBounds(530, 20, 100, 90);

        westLabel2.setFont(new java.awt.Font("Utsaah", 0, 18));
        westLabel2.setForeground(new java.awt.Color(240, 240, 240));
        westLabel2.setText("WESTMINSTER");
        getContentPane().add(westLabel2);
        westLabel2.setBounds(540, 80, 160, 40);

        chicLabel1.setFont(new java.awt.Font("Utsaah", 0, 18));
        chicLabel1.setForeground(new java.awt.Color(240, 240, 240));
        chicLabel1.setText("CHICHEN ITZA");
        getContentPane().add(chicLabel1);
        chicLabel1.setBounds(230, 170, 160, 24);

        chicLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/soccer.png")));
        getContentPane().add(chicLabel2);
        chicLabel2.setBounds(240, 100, 110, 70);

        chicButton.setOpaque(false);
        chicButton.setContentAreaFilled(false);
        chicButton.setBorderPainted(false);
        getContentPane().add(chicButton);
        chicButton.setBounds(220, 120, 120, 80);

        mapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/worldmap/map.jpg")));
        getContentPane().add(mapLabel);
        mapLabel.setBounds(0, 0, 1060, 500);

        sydneyButton.setOpaque(false);
        sydneyButton.setContentAreaFilled(false);
        sydneyButton.setBorderPainted(false);
        getContentPane().add(sydneyButton);
        sydneyButton.setBounds(950, 290, 90, 70);

        hagiaButton.setToolTipText("");
        hagiaButton.setOpaque(false);
        hagiaButton.setContentAreaFilled(false);
        hagiaButton.setBorderPainted(false);
        getContentPane().add(hagiaButton);
        hagiaButton.setBounds(670, 80, 100, 80);

        waikikiButton.setOpaque(false);
        waikikiButton.setContentAreaFilled(false);
        waikikiButton.setBorderPainted(false);
        getContentPane().add(waikikiButton);
        waikikiButton.setBounds(60, 140, 100, 70);

        tableButton.setOpaque(false);
        tableButton.setContentAreaFilled(false);
        tableButton.setBorderPainted(false);
        getContentPane().add(tableButton);
        tableButton.setBounds(640, 330, 90, 60);

        forbidButton.setOpaque(false);
        forbidButton.setContentAreaFilled(false);
        forbidButton.setBorderPainted(false);
        getContentPane().add(forbidButton);
        forbidButton.setBounds(860, 90, 110, 80);

        pack();
    }

    // 
    /*jButton1MouseEntered method
     *This method adjusts the labels when mouse enters the button.
     * @param MouseEvent evt
     */
    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/westminster.png"));
        westLabel1.setIcon(II);
        westLabel2.setFont(new java.awt.Font("Utahh", 2, 20));
    }

    /*jButton1MouseExited method
     *This method adjusts the labels when mouse exits the button.
     * @param MouseEvent evt
     */
    private void jButton1MouseExited(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/soccer.png"));
        westLabel1.setIcon(II);
        westLabel2.setFont(new java.awt.Font("Utahh", 0, 14));
    }

    /*jButton6MouseEntered method
     *This method adjusts the labels when mouse enters the button.
     * @param MouseEvent evt
     */
    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/hagiasophia.png"));
        hagiaLabel1.setIcon(II);
        hagiaLabel2.setFont(new java.awt.Font("Utahh", 2, 20));
    }

    /*jButton6MouseExited method
     *This method adjusts the labels when mouse exits the button.
     * @param MouseEvent evt
     */
    private void jButton6MouseExited(java.awt.event.MouseEvent evt)
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/soccer.png"));
        hagiaLabel1.setIcon(II);
        hagiaLabel2.setFont(new java.awt.Font("Utahh", 0, 14));
    }

    /*jButton3MouseEntered method
     *This method adjusts the labels when mouse enters the button.
     * @param MouseEvent evt
     */
    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/forbiddencity.png"));
        forbidLabel1.setIcon(II);
        forbidLabel2.setFont(new java.awt.Font("Utahh", 2, 20));
    }

    /*jButton3MouseExited method
     *This method adjusts the labels when mouse exits the button.
     * @param MouseEvent evt
     */
    private void jButton3MouseExited(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/soccer.png"));
        forbidLabel1.setIcon(II);
        forbidLabel2.setFont(new java.awt.Font("Utahh", 0, 14));
    }

    /*jButton5MouseEntered method
     *This method adjusts the labels when mouse enters the button.
     * @param MouseEvent evt
     */
    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/waikiki.png"));
        waikikiLabel2.setIcon(II);
        waikikiLabel1.setFont(new java.awt.Font("Utahh", 2, 20));
    }

    /*jButton5MouseExited method
     *This method adjusts the labels when mouse exits the button.
     * @param MouseEvent evt
     */
    private void jButton5MouseExited(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/soccer.png"));
        waikikiLabel2.setIcon(II);
        waikikiLabel1.setFont(new java.awt.Font("Utahh", 0, 14));
    }

    /*jButton7MouseEntered method
     *This method adjusts the labels when mouse enters the button.
     * @param MouseEvent evt
     */
    private void jButton7MouseEntered(java.awt.event.MouseEvent evt)
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/sydney.png"));
        sydneyLabel2.setIcon(II);
        sydneyLabel1.setFont(new java.awt.Font("Utahh", 2, 20));
    }

    /*jButton7MouseExited method
     *This method adjusts the labels when mouse exits the button.
     * @param MouseEvent evt
     */
    private void jButton7MouseExited(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/soccer.png"));
        sydneyLabel2.setIcon(II);
        sydneyLabel1.setFont(new java.awt.Font("Utahh", 0, 14));
    }

    /*jButton4MouseEntered method
     *This method adjusts the labels when mouse enters the button.
     * @param MouseEvent evt
     */
    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/tablemountain.png"));
        tableLabel1.setIcon(II);
        tableLabel2.setFont(new java.awt.Font("Utahh", 2, 20));
    }

    /*jButton4MouseExited method
     *This method adjusts the labels when mouse exits the button.
     * @param MouseEvent evt
     */
    private void jButton4MouseExited(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/soccer.png"));
        tableLabel1.setIcon(II);
        tableLabel2.setFont(new java.awt.Font("Utahh", 0, 14));
    }

    /*jButton2MouseEntered method
     *This method adjusts the labels when mouse enters the button.
     * @param MouseEvent evt
     */
    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/chicenitza.png"));
        chicLabel2.setIcon(II);
        chicLabel1.setFont(new java.awt.Font("Utahh", 2, 20));
    }

    /*jButton2MouseExited method
     *This method adjusts the labels when mouse exits the button.
     * @param MouseEvent evt
     */
    private void jButton2MouseExited(java.awt.event.MouseEvent evt) 
    {
        ImageIcon II = new ImageIcon(getClass().getResource("/images/soccer.png"));
        chicLabel2.setIcon(II);
        chicLabel1.setFont(new java.awt.Font("Utahh", 0, 14));
    }

    /*jButton5ActionPerformed method
     *This method launches level properties frame according to the selected city.
     * @param MouseEvent evt
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new LevelProperties("waikikiBeach").setVisible(true);;
        this.dispose();
    }

    /*jButton2ActionPerformed method
     *This method launches level properties frame according to the selected city.
     * @param MouseEvent evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new LevelProperties("chichenItza").setVisible(true);;
        this.dispose();
    }

    /*jButton1ActionPerformed method
     *This method launches level properties frame according to the selected city.
     * @param MouseEvent evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        new LevelProperties("westminster").setVisible(true);;
        this.dispose();
    }

    /*jButton6ActionPerformed method
     *This method launches level properties frame according to the selected city.
     * @param MouseEvent evt
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new LevelProperties("hagiaSophia").setVisible(true);;
        this.dispose();
    }

    /*jButton3ActionPerformed method
     *This method launches level properties frame according to the selected city.
     * @param MouseEvent evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new LevelProperties("forbiddenCity").setVisible(true);;
        this.dispose();
    }

    /*jButton4ActionPerformed method
     *This method launches level properties frame according to the selected city.
     * @param MouseEvent evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new LevelProperties("tableMountain").setVisible(true);;
        this.dispose();
    }

    /*jButton7ActionPerformed method
     *This method launches level properties frame according to the selected city.
     * @param MouseEvent evt
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)
    {
        new LevelProperties("sydneyOperaHouse").setVisible(true);;
        this.dispose();
    }
}
