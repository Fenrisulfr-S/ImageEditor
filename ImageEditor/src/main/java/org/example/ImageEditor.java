package org.example;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageEditor {

    private BufferedImage image;
    private Graphics2D g2d;

    public ImageEditor(String imagePath) throws IOException {
// Загружаем изображение в объект BufferedImage
        image = ImageIO.read(new File(imagePath));

// Получаем Graphics2D объект, чтобы рисовать на изображении
        g2d = (Graphics2D) image.getGraphics();
    }

    // Метод для вставки текста на картинку
    public ImageEditor addText(String text, int x, int y, String fontName, int fontSize, Color color) {
// Создаем объект Font для использования указанного шрифта и размера
        Font font = new Font(fontName, Font.PLAIN, fontSize);

// Устанавливаем свойства шрифта и цвет текста
        g2d.setFont(font);
        g2d.setColor(color);

// Рисуем текст на изображении по указанным координатам
        g2d.drawString(text, x, y);

// Возвращаем текущий объект, чтобы можно было вызывать методы цепочкой
        return this;
    }

    // Метод для сохранения измененного изображения в файл
    public void save(String outputPath) throws IOException {
// Записываем изображение в указанный файл
        ImageIO.write(image, "png", new File(outputPath));
    }

    public static void main(String[] args) throws IOException {
// Создаем объект ImageEditor для работы с картинкой
        ImageEditor imageEditor = new ImageEditor("image.jpg");

// Вставляем текст на картинку
        imageEditor.addText("Hello World!", 50, 50, "Arial", 100, Color.BLACK);

// Сохраняем измененное изображение в файл
        imageEditor.save("output.png");
    }

}