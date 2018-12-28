package dbsi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainJFrame extends JFrame {

	/**
	 * This holds the complete GUI logic of the Neo4j CRUD application 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField movieTextField;
	private JTextField genreTextField;
	private JTextField directorTextField;
	private JTextField actorTextField;
	private JTextField moviefrom;
	private JTextField genrefrom;
	private JTextField directorfrom;
	private JTextField actorfrom;
	private JTextField movieto;
	private JTextField genreto;
	private JTextField directorto;
	private JTextField actorto;
	private JTextField deleteMovieText;
	private JTextField deleteGenreText;
	private JTextField deleteDirectorText;
	private JTextField deleteActorText;
	private JTextField dsearchtextField;
	private JTextField asearchtextField;
	private JTextField gsearchtextField;
	private JTable searchTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		Main mainObj = new Main();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, "name_87139293261773");
		mainPanel.setLayout(null);
		
		JLabel lblPerformBasicQueries = new JLabel("Perform Basic Queries on Neo4j");
		lblPerformBasicQueries.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerformBasicQueries.setBounds(6, 22, 591, 16);
		mainPanel.add(lblPerformBasicQueries);
		
		JPanel createPanel = new JPanel();
		contentPane.add(createPanel, "name_87139305335262");
		createPanel.setLayout(null);
		
		JLabel movielbl = new JLabel("Movie:");
		movielbl.setBounds(43, 70, 61, 16);
		createPanel.add(movielbl);
		
		movieTextField = new JTextField();
		movieTextField.setBounds(116, 63, 134, 28);
		createPanel.add(movieTextField);
		movieTextField.setColumns(10);
		
		JLabel genrelbl = new JLabel("Genre:");
		genrelbl.setBounds(43, 103, 61, 16);
		createPanel.add(genrelbl);
		
		genreTextField = new JTextField();
		genreTextField.setColumns(10);
		genreTextField.setBounds(116, 97, 134, 28);
		createPanel.add(genreTextField);
		
		JLabel directorlbl = new JLabel("Director:");
		directorlbl.setBounds(43, 137, 61, 16);
		createPanel.add(directorlbl);
		
		directorTextField = new JTextField();
		directorTextField.setColumns(10);
		directorTextField.setBounds(116, 131, 134, 28);
		createPanel.add(directorTextField);
		
		JLabel actorlbl = new JLabel("Actor:");
		actorlbl.setBounds(43, 171, 61, 16);
		createPanel.add(actorlbl);
		
		actorTextField = new JTextField();
		actorTextField.setColumns(10);
		actorTextField.setBounds(116, 165, 134, 28);
		createPanel.add(actorTextField);
		
		JLabel statuslabel = new JLabel("Status:");
		statuslabel.setBounds(285, 69, 61, 16);
		createPanel.add(statuslabel);
		
		JLabel createResult = new JLabel("");
		createResult.setForeground(Color.BLUE);
		createResult.setBackground(Color.LIGHT_GRAY);
		createResult.setBounds(337, 70, 260, 16);
		createPanel.add(createResult);
		
		JLabel lblCreat = new JLabel("CREATE");
		lblCreat.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCreat.setBounds(236, 11, 80, 16);
		createPanel.add(lblCreat);
		
		JPanel updatePanel = new JPanel();
		updatePanel.setLayout(null);
		contentPane.add(updatePanel, "name_88111335263405");
		
		JLabel umovielbl = new JLabel("Movie:");
		umovielbl.setBounds(44, 115, 61, 16);
		updatePanel.add(umovielbl);
		
		moviefrom = new JTextField();
		moviefrom.setColumns(10);
		moviefrom.setBounds(117, 109, 134, 28);
		updatePanel.add(moviefrom);
		
		JLabel ugenrelbl = new JLabel("Genre:");
		ugenrelbl.setBounds(44, 148, 61, 16);
		updatePanel.add(ugenrelbl);
		
		genrefrom = new JTextField();
		genrefrom.setColumns(10);
		genrefrom.setBounds(117, 142, 134, 28);
		updatePanel.add(genrefrom);
		
		JLabel udirectorlbl = new JLabel("Director:");
		udirectorlbl.setBounds(44, 182, 61, 16);
		updatePanel.add(udirectorlbl);
		
		directorfrom = new JTextField();
		directorfrom.setColumns(10);
		directorfrom.setBounds(117, 176, 134, 28);
		updatePanel.add(directorfrom);
		
		JLabel uactorlbl = new JLabel("Actor:");
		uactorlbl.setBounds(44, 216, 61, 16);
		updatePanel.add(uactorlbl);
		
		actorfrom = new JTextField();
		actorfrom.setColumns(10);
		actorfrom.setBounds(117, 210, 134, 28);
		updatePanel.add(actorfrom);
		
		JLabel label_4 = new JLabel("Status:");
		label_4.setBounds(44, 306, 61, 16);
		updatePanel.add(label_4);
		
		JLabel updateResult = new JLabel("");
		updateResult.setForeground(Color.BLUE);
		updateResult.setBackground(Color.LIGHT_GRAY);
		updateResult.setBounds(117, 306, 480, 16);
		updatePanel.add(updateResult);
		
		JLabel fromlbl = new JLabel("From");
		fromlbl.setBounds(117, 92, 61, 16);
		updatePanel.add(fromlbl);
		
		JLabel tolbl = new JLabel("To");
		tolbl.setBounds(269, 92, 61, 16);
		updatePanel.add(tolbl);
		
		movieto = new JTextField();
		movieto.setColumns(10);
		movieto.setBounds(269, 109, 134, 28);
		updatePanel.add(movieto);
		
		genreto = new JTextField();
		genreto.setColumns(10);
		genreto.setBounds(269, 142, 134, 28);
		updatePanel.add(genreto);
		
		directorto = new JTextField();
		directorto.setColumns(10);
		directorto.setBounds(269, 176, 134, 28);
		updatePanel.add(directorto);
		
		actorto = new JTextField();
		actorto.setColumns(10);
		actorto.setBounds(269, 210, 134, 28);
		updatePanel.add(actorto);
		
		JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUpdate.setBounds(254, 9, 80, 16);
		updatePanel.add(lblUpdate);
		
		JPanel deletePanel = new JPanel();
		contentPane.add(deletePanel, "name_89149995444945");
		deletePanel.setLayout(null);
		
		JLabel label = new JLabel("Movie:");
		label.setBounds(43, 100, 61, 16);
		deletePanel.add(label);
		
		deleteMovieText = new JTextField();
		deleteMovieText.setColumns(10);
		deleteMovieText.setBounds(116, 94, 134, 28);
		deletePanel.add(deleteMovieText);
		
		JLabel label_1 = new JLabel("Genre:");
		label_1.setBounds(43, 133, 61, 16);
		deletePanel.add(label_1);
		
		deleteGenreText = new JTextField();
		deleteGenreText.setColumns(10);
		deleteGenreText.setBounds(116, 127, 134, 28);
		deletePanel.add(deleteGenreText);
		
		JLabel label_2 = new JLabel("Director:");
		label_2.setBounds(43, 167, 61, 16);
		deletePanel.add(label_2);
		
		deleteDirectorText = new JTextField();
		deleteDirectorText.setColumns(10);
		deleteDirectorText.setBounds(116, 161, 134, 28);
		deletePanel.add(deleteDirectorText);
		
		JLabel label_3 = new JLabel("Actor:");
		label_3.setBounds(43, 201, 61, 16);
		deletePanel.add(label_3);
		
		deleteActorText = new JTextField();
		deleteActorText.setColumns(10);
		deleteActorText.setBounds(116, 195, 134, 28);
		deletePanel.add(deleteActorText);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDelete.setBounds(254, 9, 80, 16);
		deletePanel.add(lblDelete);
		
		JLabel label_6 = new JLabel("Status:");
		label_6.setBounds(43, 294, 61, 16);
		deletePanel.add(label_6);
		
		JLabel deleteResult = new JLabel("");
		deleteResult.setForeground(Color.BLUE);
		deleteResult.setBackground(Color.LIGHT_GRAY);
		deleteResult.setBounds(116, 294, 481, 16);
		deletePanel.add(deleteResult);
		
		JPanel searchPanel = new JPanel();
		contentPane.add(searchPanel, "name_89959371970415");
		searchPanel.setLayout(null);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSearch.setBounds(254, 9, 80, 16);
		searchPanel.add(lblSearch);
		
		JLabel lblSearchMovieBy = new JLabel("Search Movie by Director");
		lblSearchMovieBy.setBounds(33, 68, 188, 16);
		searchPanel.add(lblSearchMovieBy);
		
		JLabel lblSearchMovieBy_1 = new JLabel("Search Movie by Actor");
		lblSearchMovieBy_1.setBounds(33, 158, 188, 16);
		searchPanel.add(lblSearchMovieBy_1);
		
		JLabel lblSearchMovieBy_2 = new JLabel("Search Movie by Genre");
		lblSearchMovieBy_2.setBounds(33, 235, 188, 16);
		searchPanel.add(lblSearchMovieBy_2);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(43, 96, 61, 16);
		searchPanel.add(lblDirector);
		
		JLabel lblActor = new JLabel("Actor:");
		lblActor.setBounds(43, 186, 61, 16);
		searchPanel.add(lblActor);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(43, 263, 61, 16);
		searchPanel.add(lblGenre);
		
		dsearchtextField = new JTextField();
		dsearchtextField.setBounds(116, 90, 134, 28);
		searchPanel.add(dsearchtextField);
		dsearchtextField.setColumns(10);
		
		asearchtextField = new JTextField();
		asearchtextField.setColumns(10);
		asearchtextField.setBounds(116, 180, 134, 28);
		searchPanel.add(asearchtextField);
		
		gsearchtextField = new JTextField();
		gsearchtextField.setColumns(10);
		gsearchtextField.setBounds(116, 257, 134, 28);
		searchPanel.add(gsearchtextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(409, 69, 188, 224);
		searchPanel.add(scrollPane);
		
		searchTable = new JTable();
		scrollPane.setViewportView(searchTable);
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchTable.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		JLabel lblMovies = new JLabel("Movies");
		lblMovies.setBounds(472, 43, 61, 16);
		searchPanel.add(lblMovies);
		
		JButton createbtn = new JButton("CREATE");
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(createPanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		createbtn.setBounds(117, 102, 147, 55);
		mainPanel.add(createbtn);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(updatePanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		updatebtn.setBounds(326, 102, 139, 55);
		mainPanel.add(updatebtn);
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(deletePanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		deletebtn.setBounds(117, 203, 147, 55);
		mainPanel.add(deletebtn);
		
		JButton searchbtn = new JButton("SEARCH");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(searchPanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		searchbtn.setBounds(326, 203, 139, 55);
		mainPanel.add(searchbtn);
		
		JButton backButton = new JButton("<- Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(mainPanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		createPanel.add(backButton);
		
		JButton ubackbutton = new JButton("<- Back");
		ubackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(mainPanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		ubackbutton.setBounds(6, 6, 117, 29);
		updatePanel.add(ubackbutton);
		
		JButton dbackbutton = new JButton("<- Back");
		dbackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(mainPanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		dbackbutton.setBounds(6, 6, 117, 29);
		deletePanel.add(dbackbutton);
		
		JButton sbackbutton = new JButton("<- Back");
		sbackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();
				contentPane.revalidate();
				contentPane.add(mainPanel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		sbackbutton.setBounds(6, 6, 117, 29);
		searchPanel.add(sbackbutton);
		
		JLabel label_5 = new JLabel("Status:");
		label_5.setBounds(43, 318, 61, 16);
		searchPanel.add(label_5);
		
		JLabel searchResult = new JLabel("");
		searchResult.setForeground(Color.BLUE);
		searchResult.setBackground(Color.LIGHT_GRAY);
		searchResult.setBounds(116, 318, 481, 16);
		searchPanel.add(searchResult);
		
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String movie = movieTextField.getText();
				String director = directorTextField.getText();
				String actor = actorTextField.getText();
				String genre = genreTextField.getText();
				if(movie.isEmpty() || director.isEmpty() || actor.isEmpty() || genre.isEmpty()){
					JOptionPane.showMessageDialog(null, "Parameters should not be empty, mention all the details");
				}else{
					mainObj.createMovie(movie, director, actor, genre);
					createResult.setText("Successfully added the movie");
					movieTextField.setText("");
					directorTextField.setText("");
					actorTextField.setText("");
					genreTextField.setText("");
				}
		
			}
		});
		createButton.setBounds(285, 216, 117, 29);
		createPanel.add(createButton);
		
		JButton umoviebutton = new JButton("Update Movie");
		umoviebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = moviefrom.getText();
				String to = movieto.getText();
				if(from.isEmpty() || to.isEmpty()){
					JOptionPane.showMessageDialog(null, "Movies from and to parameters should not be empty.");
				}else{
					String result = mainObj.updateMovie(from, to);	
					updateResult.setText(result);
					moviefrom.setText("");
					movieto.setText("");
				}
			}
		});
		umoviebutton.setBounds(415, 110, 134, 29);
		updatePanel.add(umoviebutton);
		
		JButton btnUpdateGenre = new JButton("Update Genre");
		btnUpdateGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = genrefrom.getText();
				String to = genreto.getText();
				if(from.isEmpty() || to.isEmpty()){
					JOptionPane.showMessageDialog(null, "Genres from and to parameters should not be empty.");
				}else{
					String result = mainObj.updateGenre(from, to);	
					updateResult.setText(result);
					genrefrom.setText("");
					genreto.setText("");
				}
			}
		});
		btnUpdateGenre.setBounds(415, 143, 134, 29);
		updatePanel.add(btnUpdateGenre);
		
		JButton btnUpdateDirector = new JButton("Update Director");
		btnUpdateDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = directorfrom.getText();
				String to = directorto.getText();
				if(from.isEmpty() || to.isEmpty()){
					JOptionPane.showMessageDialog(null, "Director from and to parameters should not be empty.");
				}else{
					String result = mainObj.updateDirector(from, to);	
					updateResult.setText(result);
					directorfrom.setText("");
					directorto.setText("");
				}
			}
		});
		btnUpdateDirector.setBounds(415, 177, 134, 29);
		updatePanel.add(btnUpdateDirector);
		
		JButton btnUpdateActor = new JButton("Update Actor");
		btnUpdateActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = actorfrom.getText();
				String to = actorto.getText();
				if(from.isEmpty() || to.isEmpty()){
					JOptionPane.showMessageDialog(null, "Actor from and to parameters should not be empty.");
				}else{
					String result = mainObj.updateActor(from, to);	
					updateResult.setText(result);
					actorfrom.setText("");
					actorto.setText("");
				}
			}
		});
		btnUpdateActor.setBounds(415, 211, 134, 29);
		updatePanel.add(btnUpdateActor);
		
		JButton btnSearchByDirector = new JButton("Search by Director");
		btnSearchByDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String col[] = {"Movies"};
				DefaultTableModel resultTable = new DefaultTableModel(col, 0);
				resultTable.setRowCount(0);
				searchTable.setModel(resultTable);
				String searchField = dsearchtextField.getText();
				if(searchField.isEmpty()){
					JOptionPane.showMessageDialog(null, "Director search field should not be empty.");
				}else{
					ArrayList<String> result = mainObj.searchMoviebyDirector(searchField) ;
					if(result.isEmpty()){
						searchResult.setText("No movies exists for director: " + searchField);
					}else{
						Object eachRow[];
						for(String elem : result){
							eachRow = new String[] {elem};
							resultTable.addRow(eachRow);
						}
						searchResult.setText("Found some movies for director: " + searchField);
						searchTable.setModel(resultTable);
					}
					dsearchtextField.setText("");
				}
			}
		});
		btnSearchByDirector.setBounds(254, 91, 159, 29);
		searchPanel.add(btnSearchByDirector);
		
		JButton btnSearchByActor = new JButton("Search by Actor");
		btnSearchByActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String col[] = {"Movies"};
				DefaultTableModel resultTable = new DefaultTableModel(col, 0);
				resultTable.setRowCount(0);
				searchTable.setModel(resultTable);
				String searchField = asearchtextField.getText();
				if(searchField.isEmpty()){
					JOptionPane.showMessageDialog(null, "Actor search field should not be empty.");
				}else{
					ArrayList<String> result = mainObj.searchMoviebyActor(searchField) ;
					if(result.isEmpty()){
						searchResult.setText("No movies exists for actor: " + searchField);
					}else{
						Object eachRow[];
						for(String elem : result){
							eachRow = new String[] {elem};
							resultTable.addRow(eachRow);
						}
						searchResult.setText("Found some movies for actor: " + searchField);
						searchTable.setModel(resultTable);
					}
					asearchtextField.setText("");
				}
			}
		});
		btnSearchByActor.setBounds(254, 181, 159, 29);
		searchPanel.add(btnSearchByActor);
		
		JButton btnSearchByGenre = new JButton("Search by Genre");
		btnSearchByGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String col[] = {"Movies"};
				DefaultTableModel resultTable = new DefaultTableModel(col, 0);
				resultTable.setRowCount(0);
				searchTable.setModel(resultTable);
				String searchField = gsearchtextField.getText();
				if(searchField.isEmpty()){
					JOptionPane.showMessageDialog(null, "Genre search field should not be empty.");
				}else{
					ArrayList<String> result = mainObj.searchMoviebyGenre(searchField) ;
					if(result.isEmpty()){
						searchResult.setText("No movies exists for genre: " + searchField);
					}else{
						Object eachRow[];
						for(String elem : result){
							eachRow = new String[] {elem};
							resultTable.addRow(eachRow);
						}
						searchResult.setText("Found some movies for genre: " + searchField);
						searchTable.setModel(resultTable);
					}
					gsearchtextField.setText("");
				}
			}
		});
		btnSearchByGenre.setBounds(254, 258, 159, 29);
		searchPanel.add(btnSearchByGenre);
		
		JButton deletemoviebtn = new JButton("Delete Movie");
		deletemoviebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteField = deleteMovieText.getText();
				if(deleteField.isEmpty()){
					JOptionPane.showMessageDialog(null, "Movie delete field should not be empty");
				}else{
					String result = mainObj.deleteMovie(deleteField);	
					deleteResult.setText(result);
					deleteMovieText.setText("");
				}
			}
		});
		deletemoviebtn.setBounds(414, 95, 134, 29);
		deletePanel.add(deletemoviebtn);
		
		JButton deletegenrebtn = new JButton("Delete Genre");
		deletegenrebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteField = deleteGenreText.getText();
				if(deleteField.isEmpty()){
					JOptionPane.showMessageDialog(null, "Genre delete field should not be empty");
				}else{
					String result = mainObj.deleteGenre(deleteField);	
					deleteResult.setText(result);
					deleteGenreText.setText("");
				}
			}
		});
		deletegenrebtn.setBounds(414, 128, 134, 29);
		deletePanel.add(deletegenrebtn);
		
		JButton deletedirectorbtn = new JButton("Delete Director");
		deletedirectorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteField = deleteDirectorText.getText();
				if(deleteField.isEmpty()){
					JOptionPane.showMessageDialog(null, "Director delete field should not be empty");
				}else{
					String result = mainObj.deleteDirector(deleteField);	
					deleteResult.setText(result);
					deleteDirectorText.setText("");
				}
			}
		});
		deletedirectorbtn.setBounds(414, 162, 134, 29);
		deletePanel.add(deletedirectorbtn);
		
		JButton deleteactorbtn = new JButton("Delete Actor");
		deleteactorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deleteField = deleteActorText.getText();
				if(deleteField.isEmpty()){
					JOptionPane.showMessageDialog(null, "Actor delete field should not be empty");
				}else{
					String result = mainObj.deleteActor(deleteField);	
					deleteResult.setText(result);
					deleteActorText.setText("");
				}
			}
		});
		deleteactorbtn.setBounds(414, 196, 134, 29);
		deletePanel.add(deleteactorbtn);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				mainObj.getDbsiIMDB().shutdown();
			}
		});
	}
}
