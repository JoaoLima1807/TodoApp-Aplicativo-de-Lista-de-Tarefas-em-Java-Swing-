# TodoApp: Aplicativo de Lista de Tarefas em Java (Swing) 📝

Este é um projeto simples de um aplicativo de lista de tarefas desenvolvido em Java usando a biblioteca **Swing** para a interface gráfica (GUI) e o **IntelliJ IDEA UI Designer** para o layout visual.

## Tecnologias Utilizadas 🛠️

*   **Linguagem:** Java
*   **Interface Gráfica:** Java Swing (nativo do JDK)
*   **IDE:** IntelliJ IDEA Community Edition (com o plugin UI Designer)

## Configuração do Layout (Visual Designer) 📐

A interface foi criada visualmente usando o **IntelliJ GUI Designer**. A imagem abaixo (ou a sua screenshot original) ilustra a configuração principal:

### Detalhes da Configuração:

*   **Componente Principal:** O painel principal (`JPanel`) foi nomeado como **`mainPanel`** na propriedade `field name` (campo de nome da variável). Este painel age como o contêiner principal para todos os outros elementos.
*   **Layout:** O `Layout Manager` padrão do designer (geralmente um `GridLayoutManager` proprietário do IntelliJ) organiza os componentes.
*   **Componentes Adicionais:** Foram adicionados um `JTextField` (`textField1`) para entrada de texto, um `JButton` (`button1`) para adicionar tarefas e um `JList` (`list1`) para exibir a lista, todos com nomes de variáveis (`field name`) configurados para fácil acesso via código Java.

## Código Fonte (`TodoForm.java`) 💻

O código Java abaixo gerencia a lógica de inicialização da janela, a captura de eventos do botão e a manipulação dos dados da lista.

```java
import javax.swing.*;

public class TodoForm {
    // Variáveis que o IntelliJ vinculou automaticamente ao design (.form):
    private JPanel mainPanel; 
    private JTextField textField1;
    private JButton button1;
    private JList<String> list1; // JList tipada para armazenar Strings

    // O Model é o "cérebro" que gerencia os dados da lista:
    private DefaultListModel<String> listModel;

    public TodoForm() {
        // CONSTRUTOR: Onde a lógica de eventos é conectada.
        listModel = new DefaultListModel<>();
        list1.setModel(listModel); // Associa o modelo visual aos dados

        // Adiciona um "ouvinte" de ação ao botão:
        button1.addActionListener(e -> {
            String tarefa = textField1.getText().trim();
            if (!tarefa.isEmpty()) {
                listModel.addElement(tarefa); // Adiciona a tarefa ao modelo (e na tela)
                textField1.setText("");       // Limpa o campo de texto
            }
        });
    }

    public static void main(String[] args) {
        // MÉTODO MAIN: O ponto de entrada da aplicação.
        JFrame frame = new JFrame("Minha Lista de Tarefas");
        // Define que o 'mainPanel' do nosso formulário será o conteúdo da janela:
        frame.setContentPane(new TodoForm().mainPanel); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta o tamanho da janela
        frame.setSize(400, 300); // Define um tamanho mínimo customizado
        frame.setVisible(true); // Torna a janela visível
    }
}
