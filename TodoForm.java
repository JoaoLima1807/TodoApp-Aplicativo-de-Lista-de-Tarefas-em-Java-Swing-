import javax.swing.*;

public class TodoForm {
    // Variáveis que o IntelliJ vinculou:
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton button1;
    private JList<String> list1; // Adicione <String> aqui

    // O Model é necessário para manipular os itens da JList
    private DefaultListModel<String> listModel;

    public TodoForm() {
        // Inicializa o modelo e conecta a lógica do botão
        listModel = new DefaultListModel<>();
        list1.setModel(listModel);

        button1.addActionListener(e -> {
            String tarefa = textField1.getText().trim();
            if (!tarefa.isEmpty()) {
                listModel.addElement(tarefa);
                textField1.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha Lista de Tarefas");
        // Usa a variável que você acabou de nomear no Designer:
        frame.setContentPane(new TodoForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

