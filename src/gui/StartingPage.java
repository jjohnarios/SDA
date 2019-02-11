package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sdapkg.League;
import sdapkg.NNhandler;
import sdapkg.ReadEloNames;
import sdapkg.Team;

/**
 *
 * @author User
 */
public class StartingPage extends javax.swing.JFrame {

    /**
     * Creates new form StartingPage
     */
    Dimension screenSize;
    private double width;
    private double height;
    private JPanel temp;
    private JLabel t;
    private String[] LeaguesNames;
    private String[] EloLeagues;
    private League league;
    private boolean loading;
    private int previousID;
    private int id;
    private HashMap<Integer, League> leagues;
    private ArrayList<String> teamNames;
    Thread thread;
    ArrayList<JButton> buttons;
    HashMap<Integer,NNhandler> handl;
    DefaultTableModel modelPredictions;
    
    public StartingPage() {

        initComponents();
         modelPredictions = new DefaultTableModel();
         Object[] columns = {"Home vs Away", "Propabillities"};
         modelPredictions.addColumn(columns[0]);
         modelPredictions.addColumn(columns[1]);
         
         predictionsTable.setModel(modelPredictions);
         
        id = -1;
        leagues = new HashMap<>();
        handl=new HashMap<>();
        loading = false;
        loadingLabel.setVisible(false);

        // gia na min mporei na ta kanei edit o xrhsths 
        teamTable.setEnabled(false);
        sequencesTable.setEnabled(false);
        predictionsTable.setEnabled(false);

        //loading Gif
        String Lt[] = {"EngPrem", "EngChamp", "ScotPrem",
            "Italy_A", "Italy_B", "Bundesliga", "2.Bundes", "FranceD1", "FranceD2", "PrimeraDiv",
            "SegundaDiv", "Portugal", "Belgian", "Austria",
            "Croatia", "Denmark", "Greece",
            "Norway", "Poland", "Russia", "SwedAll",
            "SwissNLA", "Turkey", "Ukraine"};
        LeaguesNames = Lt;
        String LtElo[] = {"ENG", "ENG", "SCO", "ITA", "ITA",
            "GER", "GER", "FRA", "FRA", "ESP",
            "ESP", "POR", "BEL", "AUT",
            "CRO", "DEN", "GRE",
            "NOR", "POL", "RUS", "SWE",
            "SUI", "TUR", "UKR"};
        EloLeagues = LtElo;
        
        teamNames=new ArrayList();
        
        buttons=new ArrayList<>();
        buttons.add(jButton1);
        buttons.add(jButton2);
        buttons.add(jButton3);
        buttons.add(jButton4);
        buttons.add(jButton5);
        buttons.add(jButton6);
        buttons.add(jButton7);
        buttons.add(jButton8);
        buttons.add(jButton9);
        buttons.add(jButton10);
        buttons.add(jButton11);
        buttons.add(jButton12);
        buttons.add(jButton13);
        buttons.add(jButton14);
        buttons.add(jButton15);
        buttons.add(jButton16);
        buttons.add(jButton17);
        buttons.add(jButton18);
        buttons.add(jButton19);
        buttons.add(jButton20);
        buttons.add(jButton21);
        buttons.add(jButton22);
        buttons.add(jButton23);
        buttons.add(jButton24);
        
        
        
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.width = (int) screenSize.getWidth();
        this.height = (int) screenSize.getHeight();

        this.setSize((int) (width * 0.85), (int) (height * 0.85));
        jPanel1.setSize((int) (this.width * 0.1), (int) (this.height * 0.75));
        jPanel1.setLocation(0, (int) (0.06 * this.height));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        DefaultTableCellRenderer renderer;
        renderer = (DefaultTableCellRenderer) predictionsTable.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        predictionsTable.getTableHeader().setFont(new Font("", Font.BOLD, 15));

        sequencesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        sequencesTable.getColumnModel().getColumn(0).setResizable(true);
        sequencesTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        sequencesTable.getColumnModel().getColumn(0).setResizable(false);

        teamTable.getColumnModel().getColumn(0).setResizable(true);
        teamTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        teamTable.getColumnModel().getColumn(0).setResizable(false);
        
        this.setResizable(true);
        this.revalidate();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.pack();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        L = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teamTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        sequencesTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        loadingLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        predictionsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        box1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        box2 = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();
        leagueTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        trainButton = new javax.swing.JButton();
        predict = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soccer Data Analysis");
        setMinimumSize(new java.awt.Dimension(1150, 950));
        setName(""); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        title.setBackground(new java.awt.Color(51, 51, 51));
        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("SOCCER DATA ANALYSIS");
        title.setOpaque(true);
        getContentPane().add(title);
        title.setBounds(0, 0, 0, 0);

        jPanel1.setLayout(new java.awt.GridLayout(25, 1));

        L.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L.setText("LEAGUES");
        L.setName("1"); // NOI18N
        jPanel1.add(L);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eng.jpg"))); // NOI18N
        jButton1.setText(" Premiership");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setName("1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.getAccessibleContext().setAccessibleName("Premiership");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eng.jpg"))); // NOI18N
        jButton2.setText("Championship");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setName("2"); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scot.jpg"))); // NOI18N
        jButton3.setText("Scotland");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setName("3"); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ita.jpg"))); // NOI18N
        jButton4.setText("Italy Serie A");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setName("4"); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ita.jpg"))); // NOI18N
        jButton5.setText("Italy Seria B");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setName("5"); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ger.jpg"))); // NOI18N
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setLabel("Bundesliga");
        jButton6.setName("6"); // NOI18N
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ger.jpg"))); // NOI18N
        jButton7.setText("2nd Bundes");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setName("7"); // NOI18N
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fr.jpg"))); // NOI18N
        jButton8.setText("  France D1");
        jButton8.setActionCommand("France D1");
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setName("8"); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fr.jpg"))); // NOI18N
        jButton9.setText("France D2");
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.setName("9"); // NOI18N
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton9);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/es.jpg"))); // NOI18N
        jButton10.setText("Spain");
        jButton10.setToolTipText("");
        jButton10.setAutoscrolls(true);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.setName("10"); // NOI18N
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton10);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/es.jpg"))); // NOI18N
        jButton11.setText("Spain 2nd");
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.setName("11"); // NOI18N
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton11);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pt.jpg"))); // NOI18N
        jButton12.setText("Portugal");
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.setName("12"); // NOI18N
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton12);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/be.jpg"))); // NOI18N
        jButton13.setText("Belgium");
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.setName("13"); // NOI18N
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton13);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/at.jpg"))); // NOI18N
        jButton14.setText("Austria");
        jButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton14.setName("14"); // NOI18N
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton14);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cr.jpg"))); // NOI18N
        jButton15.setText("Croatia");
        jButton15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton15.setName("15"); // NOI18N
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton15);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dk.jpg"))); // NOI18N
        jButton16.setText("Denmark");
        jButton16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton16.setName("16"); // NOI18N
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton16);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gr.jpg"))); // NOI18N
        jButton17.setText("Greece");
        jButton17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton17.setName("17"); // NOI18N
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton17);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/no.jpg"))); // NOI18N
        jButton18.setText("Norway");
        jButton18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton18.setName("18"); // NOI18N
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton18);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pl.jpg"))); // NOI18N
        jButton19.setText("Poland");
        jButton19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton19.setName("19"); // NOI18N
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton19);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ru.jpg"))); // NOI18N
        jButton20.setText("Russia");
        jButton20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton20.setName("20"); // NOI18N
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton20);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/se.jpg"))); // NOI18N
        jButton21.setText("Sweden");
        jButton21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton21.setName("21"); // NOI18N
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton21);

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ch.jpg"))); // NOI18N
        jButton22.setText("Swiss NLA");
        jButton22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton22.setName("22"); // NOI18N
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton22);

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tr.jpg"))); // NOI18N
        jButton23.setText("Turkey");
        jButton23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton23.setName("23"); // NOI18N
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton23);

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/uk.jpg"))); // NOI18N
        jButton24.setText("Ukraine");
        jButton24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton24.setName("24"); // NOI18N
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton24);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 0, 0);

        jPanel3.setLayout(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        teamTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {"", null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, "", null, null, null},
                {"", null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {"", null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Team", "Pos", "Pld", "W", "D", "L", "Gf:Ga", "+/-", "Pts", "GfA", "GaA", "Elo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teamTable.setColumnSelectionAllowed(true);
        teamTable.getTableHeader().setReorderingAllowed(false);
        teamTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teamTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teamTable);
        teamTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (teamTable.getColumnModel().getColumnCount() > 0) {
            teamTable.getColumnModel().getColumn(0).setResizable(false);
            teamTable.getColumnModel().getColumn(1).setResizable(false);
            teamTable.getColumnModel().getColumn(2).setResizable(false);
            teamTable.getColumnModel().getColumn(3).setResizable(false);
            teamTable.getColumnModel().getColumn(4).setResizable(false);
            teamTable.getColumnModel().getColumn(5).setResizable(false);
            teamTable.getColumnModel().getColumn(6).setResizable(false);
            teamTable.getColumnModel().getColumn(7).setResizable(false);
            teamTable.getColumnModel().getColumn(8).setResizable(false);
            teamTable.getColumnModel().getColumn(9).setResizable(false);
            teamTable.getColumnModel().getColumn(10).setResizable(false);
            teamTable.getColumnModel().getColumn(11).setResizable(false);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(0, 60, 960, 230);

        sequencesTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sequencesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Team", "Winning", "Winless", "Drawing", "Not Draw", "Losing", "Unbeaten"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sequencesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(sequencesTable);
        if (sequencesTable.getColumnModel().getColumnCount() > 0) {
            sequencesTable.getColumnModel().getColumn(0).setResizable(false);
            sequencesTable.getColumnModel().getColumn(1).setResizable(false);
            sequencesTable.getColumnModel().getColumn(2).setResizable(false);
            sequencesTable.getColumnModel().getColumn(3).setResizable(false);
            sequencesTable.getColumnModel().getColumn(4).setResizable(false);
            sequencesTable.getColumnModel().getColumn(5).setResizable(false);
            sequencesTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(10, 360, 452, 250);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Click on a team for more info.");
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 230, 180, 15);

        loadingLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/load.gif"))); // NOI18N
        loadingLabel.setText("Loading...");
        loadingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        loadingLabel.setIconTextGap(0);
        jPanel3.add(loadingLabel);
        loadingLabel.setBounds(330, 280, 300, 120);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sequences");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(170, 330, 109, 25);

        predictionsTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        predictionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Arsenal vs Liverpool 1 (1[75%] X[10%] 2[15%])"},
                {"Arsenal vs Liverpool 1 (1[75%] X[10%] 2[15%])"},
                {"Arsenal vs Liverpool 1 (1[75%] X[10%] 2[15%])"},
                {"Arsenal vs Liverpool 1 (1[75%] X[10%] 2[15%])"},
                {"Arsenal vs Liverpool 1 (1[75%] X[10%] 2[15%])"},
                {"predictionsTable"}
            },
            new String [] {
                "Predictions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        predictionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(predictionsTable);
        if (predictionsTable.getColumnModel().getColumnCount() > 0) {
            predictionsTable.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(510, 350, 400, 130);

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });
        jPanel2.add(box1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VS");
        jPanel2.add(jLabel3);

        jPanel2.add(box2);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(510, 490, 400, 40);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });
        jPanel3.add(refreshButton);
        refreshButton.setBounds(880, 10, 80, 50);

        leagueTitle.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        leagueTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leagueTitle.setText("NO SELECTED LEAGUE");
        jPanel3.add(leagueTitle);
        leagueTitle.setBounds(0, 30, 960, 25);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 15, 0));

        trainButton.setText("Load Predict System");
        trainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trainButtonMouseClicked(evt);
            }
        });
        jPanel4.add(trainButton);

        predict.setText("Predict");
        predict.setName("predictB"); // NOI18N
        predict.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                predictMouseClicked(evt);
            }
        });
        predict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predictActionPerformed(evt);
            }
        });
        jPanel4.add(predict);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(550, 540, 330, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(190, 0, 960, 640);

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void initThread(java.awt.event.MouseEvent evt,boolean isRefresh){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                
                if(isRefresh){
                    id=previousID;}
                else{
                    JButton b = new JButton();
                b = (JButton) evt.getComponent();
                id = Integer.parseInt(b.getName()) - 1;
                }
                
                
                 if (!leagues.containsKey(id)) {
                    predict.setEnabled(false);
                    loading = true;
                    loadingLabel.setVisible(true);
                }
                
                //gia na mhn mporei na pathsei to predict

                ReadEloNames con = new ReadEloNames();
                String url = "http://www.footballresults.org/league.php?table=1&league=";
                String urlSeq = "http://footballresults.org/sequences.php?league=";
                try {

                    if (leagues.containsKey(id)) {
                        league = leagues.get(id);
                    } else {
                        league = new League(LeaguesNames[id], con, url + LeaguesNames[id], "http://clubelo.com/" + EloLeagues[id] , urlSeq + LeaguesNames[id]);
                        league.init();
                        leagues.put(id, league);
                        
                        NNhandler handler = new NNhandler(league);
                        handl.put(id, handler);
                        String propTeams=handler.Generalpredict();
                        
                        String[] Pt=propTeams.split("\n");
                        
          for(String t : Pt){
              String[] team_and_prop=t.split(",");
              league.getTeamByIndex(league.getIndexOfTeamByName(team_and_prop[0])).setProp(team_and_prop[2]+","+team_and_prop[3]+","+team_and_prop[4]);
          }
         
                    }
                       
                 teamNames.clear();
                 teamNames.addAll(league.getAllTeamsNames());
                
                 box1.removeAllItems();
                 box2.removeAllItems();
                    
                 for(String name:teamNames){
                     
                     
                     box1.addItem(name);
                     box2.addItem(name);
                 }
                 
                    
                    
                    
                    int k = league.getNumberOfTeams();
                    DefaultTableModel model = new DefaultTableModel();
                    DefaultTableModel modelSeq = new DefaultTableModel();

                    Object[] columns = {"Team", "Pos", "Pld", "W", "D", "L", "Gf:Ga", "+/-", "Pts", "GfA", "GaA", "Elo"};
                    Object[] columnsSeq = {"Team", "Winning", "Winless", "Drawing", "Not Draw", "Losing", "Unbeaten"};
                    for (int i = 0; i < columns.length; i++) {
                        model.addColumn(columns[i]);
                    }
                    for (int i = 0; i < columnsSeq.length; i++) {
                        modelSeq.addColumn(columnsSeq[i]);
                    }

                    for (int i = 0; i < k; i++) {

                        Team tm = league.getTeamByIndex(i);

                        Object[] stats = new Object[15];
                        stats[0] = tm.getNameInSite1();
                        String[] st = tm.getStats().split(" ");
                        for (int j = 1; j < 12; j++) {
                            stats[j] = st[j - 1];
                        }

                        model.addRow(stats);

                        Object[] seq = new Object[15];
                        seq[0] = tm.getNameInSite1();
                        String[] stSeq = tm.getSeq().split(" ");

                        for (int f = 1; f < 7; f++) {
                            seq[f] = stSeq[f - 1];
                        }
                        modelSeq.addRow(seq);

                    }

                    teamTable.setModel(model);
                    sequencesTable.setModel(modelSeq);
                    
                    leagueTitle.setText(buttons.get(id).getText());
                    leagueTitle.setIcon(buttons.get(id).getIcon());

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(StartingPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                loadingLabel.setVisible(false);
                predict.setEnabled(true);
                loading = false;
            }
        });
        thread.start();

        //loadingLabel.setVisible(true);
       
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        previousID=(Integer.parseInt(evt.getComponent().getName())-1);
        initThread(evt,false);
        


    }//GEN-LAST:event_jButton1MouseClicked

    //----------
    //trexei otan den fortonoyme kapoio prwtathlima
    private void predictMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_predictMouseClicked
 
        if (loading == false && id != -1) {
            
            
            String team1=box1.getSelectedItem().toString();
            String team2=box2.getSelectedItem().toString();
            
            NNhandler h=handl.get(id);
            h.clearPredictions();
            h.addPrediction(team1, team2);
            Object[] gameResult=h.predict().split("\n");
            
            modelPredictions.addRow(gameResult);
            
        }
    }//GEN-LAST:event_predictMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
         if (loading == false && id!=-1){  
        leagues.remove(id);
        initThread(evt,true);
         }
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void predictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predictActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_predictActionPerformed

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box1ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void trainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trainButtonMouseClicked
        if (loading == false && id != -1) {
            
            NNhandler h=handl.get(id);
            h.train();

            
        }
    }//GEN-LAST:event_trainButtonMouseClicked

    private void teamTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamTableMouseClicked
         int row = teamTable.rowAtPoint(evt.getPoint());
        int col = teamTable.columnAtPoint(evt.getPoint()); 
        
        if (row >= 0 && col == 0 && id!=-1) {
           TeamStats t=new TeamStats(leagues.get(id).getTeamByIndex(row));

        }
    }//GEN-LAST:event_teamTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L;
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JComboBox<String> box2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel leagueTitle;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JButton predict;
    private javax.swing.JTable predictionsTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable sequencesTable;
    private javax.swing.JTable teamTable;
    private javax.swing.JLabel title;
    private javax.swing.JButton trainButton;
    // End of variables declaration//GEN-END:variables
}
