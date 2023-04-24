import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setBounds(0, 0, 1600, 900);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setTitle("Probando la librería Swing en Java");

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        menuBar.add(menu);
        menu = new JMenu("Acciones");
        menuBar.add(menu);
        menu = new JMenu("Ayuda");
        menuBar.add(menu);

        JMenuItem version = new JMenuItem("Versión");
        version.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Versión 1.0");
            }
        });
        menu.add(version);
        JMenuItem acerca = new JMenuItem("Acerca de");
        acerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Programa para la creación y simulación de ligas deportivas.");
            }
        });
        menu.add(acerca);

        ventana.setJMenuBar(menuBar);

        JPanel buttonsLayout = new JPanel(new GridBagLayout());
        buttonsLayout.setPreferredSize(new Dimension(400, 900));
        buttonsLayout.setBorder(BorderFactory.createMatteBorder(0,0,0,1, Color.BLACK));
        GridBagConstraints bConst = new GridBagConstraints();
        bConst.fill = GridBagConstraints.HORIZONTAL;
        bConst.ipadx = 100;
        bConst.ipady = 50;
        bConst.insets = new Insets(0, 0, 50, 0);

        // Botón nueva liga
        Boton newLiga = new Boton("Nueva Liga", 1);
        newLiga.setFocusPainted(false);
        bConst.gridy = 0;
        buttonsLayout.add(newLiga, bConst);

        // Botón jugar liga
        Boton play = new Boton("Jugar Liga", 2);
        play.setFocusPainted(false);
        bConst.gridy = 1;
        buttonsLayout.add(play, bConst);

        // Botón siguiente jornada
        Boton nextJourney = new Boton("Siguiente jornada", 3);
        nextJourney.setEnabled(false);
        nextJourney.setFocusPainted(false);
        bConst.gridy = 2;
        buttonsLayout.add(nextJourney, bConst);

        // Botón simulación completa
        Boton completeSimulation = new Boton("Simulación completa", 4);
        completeSimulation.setEnabled(false);
        completeSimulation.setFocusPainted(false);
        bConst.gridy = 3;
        buttonsLayout.add(completeSimulation, bConst);

        // Botón salir
        Boton exit = new Boton("Salir", 0);
        exit.setFocusPainted(false);
        bConst.gridy = 5;
        buttonsLayout.add(exit, bConst);

        String[] columnNames = {"Posición", "Equipo", "Partidos Ganados", "Partidos Perdidos", "Goles a Favor", "Goles en Contra", "Diferencia de Goles"};
        Object[][] data = {
                {1, "Ultimate Mostoles", 8, 3, 34, 27, 7},
                {2, "Porcinos FC", 7, 4, 37, 26, 11},
                {3, "Los Troncos FC", 7, 4, 40, 34, 6},
                {4, "Saiyans FC", 7, 4, 21, 18, 3},
                {5, "Kunisports", 7, 4, 23, 22, 1},
                {6, "xBuyer Team", 6, 5, 25, 25, 0},
                {7, "Aniquiladores FC", 6, 5, 29, 30, -1},
                {8, "El Barrio", 5, 6, 33, 25, 8},
                {9, "1K FC", 5, 6, 32, 34, -2},
                {10, "PIO FC", 4, 7, 27, 29, -2},
                {11, "Rayo de Barcelona", 3, 8, 27, 40, -13},
                {12, "Jijantes FC", 1, 10, 23, 41, -18}
        };

        JPanel tableLayout = new JPanel();
        tableLayout.setLayout(new BoxLayout(tableLayout, BoxLayout.Y_AXIS));
        tableLayout.setBorder(BorderFactory.createEmptyBorder(100,100,20,100));

        JTable clasification = new JTable(data, columnNames);
        clasification.setBorder(BorderFactory.createMatteBorder(0,1,1,1, Color.BLACK));

        JTableHeader headers = clasification.getTableHeader();
        headers.setBorder(BorderFactory.createMatteBorder(1,1,0,1, Color.BLACK));

        tableLayout.add(headers);
        tableLayout.add(clasification);

        ventana.add(buttonsLayout, BorderLayout.LINE_START);
        ventana.add(tableLayout, BorderLayout.CENTER);

        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public static class Boton extends JButton implements ActionListener, MouseListener {
        private final int function;
        public Boton(String name, int function) {
            super(name);
            this.function = function;
            this.addActionListener(this);
            this.addMouseListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(this.function) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Se ha creado una nueva liga.");
                    break;
                case 2:
                    System.out.println("Al hacer click en este botón se simulará una liga al completo");
                    break;
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(this.function) {
                case 3:
                    JOptionPane.showMessageDialog(null, "Se va a proceder a simular una jornada");
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            switch(this.function) {
                case 2:
                    System.out.println("Al hacer click en este botón se simulará una liga al completo");
                    break;
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
