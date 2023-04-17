import javax.swing.*;
import javax.swing.table.JTableHeader;

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

        ventana.setJMenuBar(menuBar);

        // Botón nueva liga
        JButton newLiga = new JButton();
        newLiga.setText("Nueva Liga");
        newLiga.setBounds(100, 100, 200, 50);
        newLiga.setFocusPainted(false);

        // Botón jugar liga
        JButton play = new JButton();
        play.setText("Jugar Liga");
        play.setBounds(100, 200, 200, 50);
        play.setFocusPainted(false);

        // Botón siguiente jornada
        JButton nextJourney = new JButton();
        nextJourney.setText("Siguiente jornada");
        nextJourney.setBounds(100, 300, 200, 50);
        nextJourney.setEnabled(false);
        nextJourney.setFocusPainted(false);

        // Botón simulación completa
        JButton completeSimulation = new JButton();
        completeSimulation.setText("Simulación completa");
        completeSimulation.setBounds(100, 400, 200, 50);
        completeSimulation.setEnabled(false);
        completeSimulation.setFocusPainted(false);

        // Botón salir
        JButton exit = new JButton();
        exit.setText("Salir");
        exit.setBounds(100, 700, 200, 50);
        exit.setFocusPainted(false);

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

        JTable clasification = new JTable(data, columnNames);
        clasification.setBounds(500, 60, 1000, 700);

        JTableHeader headers = clasification.getTableHeader();
        headers.setBounds(500, 40, 1000, 20);

        ventana.setLayout(null);
        ventana.add(newLiga);
        ventana.add(play);
        ventana.add(nextJourney);
        ventana.add(completeSimulation);
        ventana.add(exit);
        ventana.add(headers);
        ventana.add(clasification);

        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
