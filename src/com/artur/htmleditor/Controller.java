package com.artur.htmleditor;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() { //инициализация контроллера
        createNewDocument();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    // метод записывает переданный текст с html тегами в документ document
    public void setPlainText(String text) {
        resetDocument(); // сбрасываем документ
        StringReader stringReader = new StringReader(text); // создаем новый реадер StringReader на базе переданного текта
        try {
            new HTMLEditorKit().read(stringReader, document, 0); // читаем данные из реадера в документ document
        } catch (Exception e) { ExceptionHandler.log(e); } // логируем исключения
    }

    // метод получает текст из документа со всеми html тегами
    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) { ExceptionHandler.log(e); }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab(); // выбираем html вкладку у представления
        resetDocument(); // сбрасываем текущий документ
        view.setTitle("HTML редактор"); // устанавливаем новый заголовок
        view.resetUndo(); // сбрасываем правки в Undo менеджере
        currentFile = null; // обнуляем переменную currentFile
    }

    public void openDocument() {
        view.selectHtmlTab(); // переключаем представление на html вкладку
        JFileChooser fileChooser = new JFileChooser(); // новый объект для выбора файла
        fileChooser.setFileFilter(new HTMLFileFilter()); // установка фильтра
        int index = fileChooser.showOpenDialog(view); // отображение диалогового окна "Open File" для выбора файла
        if (index == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (currentFile == null) saveDocumentAs();
        else {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab(); // переключаем представление на html вкладку
        JFileChooser fileChooser = new JFileChooser(); // новый объект для выбора файла
        fileChooser.setFileFilter(new HTMLFileFilter()); // установка фильтра
        int index = fileChooser.showSaveDialog(view); // отображение диалогового окна "Save File" для выбора файла

        if (index == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile(); // если пользователь подтвердил выбор файла, сохранить выбранный файл в поле currentFile
            view.setTitle(currentFile.getName()); // установить имя файла в качестве заголовка окна представления
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) { ExceptionHandler.log(e); }
        }
    }

    public void exit() {
        System.exit(0);
    }
}
