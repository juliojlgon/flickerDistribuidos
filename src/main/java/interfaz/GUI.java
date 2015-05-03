/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.groups.Group;
import com.flickr4java.flickr.groups.pools.PoolsInterface;
import com.flickr4java.flickr.photos.PhotoSet;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.upload.Ticket;
import com.flickr4java.flickr.photos.upload.UploadInterface;
import com.flickr4java.flickr.photosets.Photoset;
import com.flickr4java.flickr.photosets.PhotosetsInterface;
import com.flickr4java.flickr.prefs.PrefsInterface;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.mycompany.flickerdistribuidos.FlickrHelper.Imagenes;
import com.urjc.java.pruautorizacionesflickr.AutorizacionesFlickr;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import filterFile.Filter;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import jdk.nashorn.internal.runtime.Context;

/**
 *
 * @author Alberto
 */
public class GUI extends javax.swing.JFrame {

    private String [] imagenesASubir;
    
    public class Imagen extends javax.swing.JPanel {
 
        private final String img;
        
        public Imagen(int x, int y, String img) {
            this.setSize(x, y);
            this.img = img;//se selecciona el tamaño del panel         
        }
 
        //Se crea un método cuyo parámetro debe ser un objeto Graphics
 
        @Override
        public void paint(Graphics grafico) {
            Dimension height = getSize();
 
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa            
            ImageIcon Img = new ImageIcon(getClass().getClassLoader().getResource(this.img)); 
 
            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }
    
    /**
     * Creates new form GUIInicio
     */
    public GUI() {
        initComponents();          
        
        flickr
                = new Flickr(autorizacionesFlickr.getApi_key(),
                        autorizacionesFlickr.getSecret(),
                        new REST());
        RequestContext rContext = RequestContext.getRequestContext();
        rContext.setAuth(autorizacionesFlickr.getAuth());
        
        Imagenes subir = new Imagenes(flickr);
        
        Scanner scanner = new Scanner(System.in);
        String sPath = null;
        Path path;
        File dir;
        
        
        //Pantalla Inicio
        pantallaInicio.setVisible(true);
        Imagen imgInicio = new Imagen(580, 490,"flickr-inicio.png");
        pantallaInicio.add(imgInicio);
        pantallaInicio.repaint();        
        
        //Oculta el resto de paneles
        panelSelectorDirectorio.setVisible(false);
        pantallaListar.setVisible(false);
        
        //Hace que el Selector de ficheros solo muestre directorios
        selectorDirectorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        //Hace que el textArea que muestra la lista de archivos a subir no se
        //pueda modificar
        listadoArchivos.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPorCapas = new javax.swing.JLayeredPane();
        pantallaInicio = new javax.swing.JPanel();
        botonInicio = new javax.swing.JButton();
        panelSelectorDirectorio = new javax.swing.JPanel();
        selectorDirectorio = new javax.swing.JFileChooser();
        pantallaListar = new javax.swing.JPanel();
        botonSubir = new javax.swing.JButton();
        cancelarListar = new javax.swing.JButton();
        listadoArchivos = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        panelPorCapas.setMaximumSize(new java.awt.Dimension(600, 600));
        panelPorCapas.setMinimumSize(new java.awt.Dimension(600, 600));

        pantallaInicio.setMaximumSize(new java.awt.Dimension(600, 600));
        pantallaInicio.setPreferredSize(new java.awt.Dimension(600, 600));

        botonInicio.setText("Subir Fotos");
        botonInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInicio.setMaximumSize(new java.awt.Dimension(80, 23));
        botonInicio.setMinimumSize(new java.awt.Dimension(80, 23));
        botonInicio.setPreferredSize(new java.awt.Dimension(80, 23));
        botonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pantallaInicioLayout = new javax.swing.GroupLayout(pantallaInicio);
        pantallaInicio.setLayout(pantallaInicioLayout);
        pantallaInicioLayout.setHorizontalGroup(
            pantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaInicioLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(botonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        pantallaInicioLayout.setVerticalGroup(
            pantallaInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaInicioLayout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(botonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        panelSelectorDirectorio.setMaximumSize(new java.awt.Dimension(600, 600));
        panelSelectorDirectorio.setMinimumSize(new java.awt.Dimension(600, 600));
        panelSelectorDirectorio.setPreferredSize(new java.awt.Dimension(600, 600));

        selectorDirectorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorDirectorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSelectorDirectorioLayout = new javax.swing.GroupLayout(panelSelectorDirectorio);
        panelSelectorDirectorio.setLayout(panelSelectorDirectorioLayout);
        panelSelectorDirectorioLayout.setHorizontalGroup(
            panelSelectorDirectorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSelectorDirectorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectorDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSelectorDirectorioLayout.setVerticalGroup(
            panelSelectorDirectorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSelectorDirectorioLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(selectorDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pantallaListar.setMaximumSize(new java.awt.Dimension(600, 600));
        pantallaListar.setMinimumSize(new java.awt.Dimension(600, 600));
        pantallaListar.setPreferredSize(new java.awt.Dimension(600, 600));

        botonSubir.setText("Subir Fotos");
        botonSubir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSubir.setMaximumSize(new java.awt.Dimension(80, 23));
        botonSubir.setMinimumSize(new java.awt.Dimension(80, 23));
        botonSubir.setPreferredSize(new java.awt.Dimension(80, 23));
        botonSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSubirActionPerformed(evt);
            }
        });

        cancelarListar.setText("Cancelar");
        cancelarListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pantallaListarLayout = new javax.swing.GroupLayout(pantallaListar);
        pantallaListar.setLayout(pantallaListarLayout);
        pantallaListarLayout.setHorizontalGroup(
            pantallaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaListarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pantallaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaListarLayout.createSequentialGroup()
                        .addComponent(cancelarListar)
                        .addGap(18, 18, 18)
                        .addComponent(botonSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaListarLayout.createSequentialGroup()
                        .addComponent(listadoArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
        );
        pantallaListarLayout.setVerticalGroup(
            pantallaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaListarLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(listadoArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(pantallaListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarListar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout panelPorCapasLayout = new javax.swing.GroupLayout(panelPorCapas);
        panelPorCapas.setLayout(panelPorCapasLayout);
        panelPorCapasLayout.setHorizontalGroup(
            panelPorCapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantallaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPorCapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPorCapasLayout.createSequentialGroup()
                    .addComponent(panelSelectorDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(panelPorCapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pantallaListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPorCapasLayout.setVerticalGroup(
            panelPorCapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPorCapasLayout.createSequentialGroup()
                .addComponent(pantallaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(panelPorCapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPorCapasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelSelectorDirectorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(panelPorCapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPorCapasLayout.createSequentialGroup()
                    .addComponent(pantallaListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelPorCapas.setLayer(pantallaInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPorCapas.setLayer(panelSelectorDirectorio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPorCapas.setLayer(pantallaListar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPorCapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPorCapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectorDirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorDirectorioActionPerformed
        // TODO add your handling code here:
        File directorio;
        String [] ficheros;
        String seleccion = evt.getActionCommand();
        
        if (seleccion.equals(JFileChooser.APPROVE_SELECTION)) {
            System.out.println("Directorio actual: "
                        +  selectorDirectorio.getCurrentDirectory());
            System.out.println("Directorio seleccionado: "
                        +  selectorDirectorio.getSelectedFile());
            

            directorio = selectorDirectorio.getSelectedFile();
            
            //Filtra las imagenes del directorio            
            ficheros = Filter.filtroImagenes(directorio);                        
            
            for (int i=0; i<ficheros.length; i++) {
                ficheros[i] = directorio + ficheros[i];
            }
            
            System.out.println("Archivos seleccionados:");
            for (String fichero : ficheros) {
                listadoArchivos.append(fichero + "\n");                
                System.out.println(fichero);
            }
            
            //Oculta el panel selector de archivos y muestra el listado
            //de archivos
            panelSelectorDirectorio.setVisible(false);
            pantallaListar.setVisible(true);
            Imagen imgLogo = new Imagen(600, 88,"flickr-logo.png");
            pantallaListar.add(imgLogo);
            pantallaListar.repaint();
            
        } else if (seleccion.equals(JFileChooser.CANCEL_SELECTION)) {
            System.out.println("Se ha pulsado el botón Cancelar.");
            //Vuelve a la pantalla de inicio
            //Pantalla Inicio
            pantallaInicio.setVisible(true);             
        
            //Oculta el resto de paneles                
            panelSelectorDirectorio.setVisible(false);  
        }
        
    }//GEN-LAST:event_selectorDirectorioActionPerformed

    private void botonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioActionPerformed
        // TODO add your handling code here:
        pantallaInicio.setVisible(false);
        
        panelSelectorDirectorio.setVisible(true);
        Imagen imgLogo = new Imagen(600, 88,"flickr-logo.png");
        panelSelectorDirectorio.add(imgLogo);
        panelSelectorDirectorio.repaint();
    }//GEN-LAST:event_botonInicioActionPerformed

    private void botonSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSubirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSubirActionPerformed

    private void cancelarListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarListarActionPerformed
        // TODO add your handling code here:
        System.out.println("Se ha pulsado el botón Cancelar.");
        
        //Borra el listado de archivos del textArea
        listadoArchivos.setText("");
        
        //Vuelve a la pantalla de inicio
        //Pantalla Inicio
        pantallaInicio.setVisible(true);             
        
        //Oculta el resto de paneles                
        pantallaListar.setVisible(false);
    }//GEN-LAST:event_cancelarListarActionPerformed

    
    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp", "jpeg", "jpg" // and other formats you need
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
    
    static Flickr flickr;

    static Set<String> pids = new HashSet<>();
    final static AutorizacionesFlickr autorizacionesFlickr
            = new AutorizacionesFlickr();
    
    
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInicio;
    private javax.swing.JButton botonSubir;
    private javax.swing.JButton cancelarListar;
    private java.awt.TextArea listadoArchivos;
    private javax.swing.JLayeredPane panelPorCapas;
    private javax.swing.JPanel panelSelectorDirectorio;
    private javax.swing.JPanel pantallaInicio;
    private javax.swing.JPanel pantallaListar;
    private javax.swing.JFileChooser selectorDirectorio;
    // End of variables declaration//GEN-END:variables

}
