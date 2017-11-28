import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.print.PrintService;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;

public class G_LiteUI
        extends JFrame
        implements Printable {
    private JButton Assem_Lang_chooser;
    private JButton Assemble;
    private JTextField C_file;
    private JButton C_lang_chooser;
    private JButton Compile_button;
    private JButton Exit_button;
    private JButton Link_button;
    private JButton Print;
    private JButton Run_button;
    private JTextField Run_file;
    private JTextField S_file;
    private JButton file_print;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane process_output;
    private JTextArea process_text;
    private JTextField studentName;

    private JTextField textDirectory;
    private JLabel labelUserDirectory;

    public G_LiteUI() {
        initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.Compile_button = new JButton();
        this.Assemble = new JButton();
        this.Link_button = new JButton();
        this.Run_button = new JButton();
        this.C_file = new JTextField();
        this.S_file = new JTextField();
        this.Run_file = new JTextField();
        this.C_lang_chooser = new JButton();
        this.Assem_Lang_chooser = new JButton();
        this.jPanel2 = new JPanel();
        this.Exit_button = new JButton();
        this.Print = new JButton();
        this.file_print = new JButton();
        this.process_output = new JScrollPane();
        this.process_text = new JTextArea();
        this.studentName = new JTextField();
        this.textDirectory = new JTextField();
        this.jLabel1 = new JLabel();
        this.labelUserDirectory = new JLabel();


        setDefaultCloseOperation(3);

        this.labelUserDirectory.setText("Paste project directory");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder("CS252 UI Assistant (S16)"));

        this.Compile_button.setText("Compile");
        this.Compile_button.setToolTipText("Press this button to compile the C program. A file cout is created in the working directory.");
        this.Compile_button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Compile_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.Compile_buttonActionPerformed(evt);
            }
        });
        this.Assemble.setText("Assemble");
        this.Assemble.setToolTipText("Press this button to assemble the ARM file. This will create an sout file in the working directory.");
        this.Assemble.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Assemble.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.AssembleActionPerformed(evt);
            }
        });
        this.Link_button.setText("Link");
        this.Link_button.setToolTipText("Press this button to create a runnable file. If a name is entered in the text box tat will be the name of the file, otherwise it is called runit.");
        this.Link_button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Link_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.Link_buttonActionPerformed(evt);
            }
        });
        this.Run_button.setText("Run");
        this.Run_button.setToolTipText("Press this button to run the file.");
        this.Run_button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Run_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.Run_buttonActionPerformed(evt);
            }
        });
        this.C_lang_chooser.setBackground(new Color(255, 255, 255));
        this.C_lang_chooser.setText("C  language file");
        this.C_lang_chooser.setToolTipText("Press this button ot chose the C lanuguage file to compile");
        this.C_lang_chooser.setActionCommand("C_language_file");
        this.C_lang_chooser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.C_lang_chooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.C_lang_chooserActionPerformed(evt);
            }
        });
        this.Assem_Lang_chooser.setBackground(new Color(255, 255, 255));
        this.Assem_Lang_chooser.setText("Assembly Language file");
        this.Assem_Lang_chooser.setToolTipText("Press this butto to chose the ARM assembly language file to assemble.");
        this.Assem_Lang_chooser.setActionCommand("Assembly_lang_file");
        this.Assem_Lang_chooser.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Assem_Lang_chooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.Assem_Lang_chooserActionPerformed(evt);
            }
        });
        this.Exit_button.setText("Exit");
        this.Exit_button.setToolTipText("This will exit the application.");
        this.Exit_button.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Exit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.Exit_buttonActionPerformed(evt);
            }
        });
        this.Print.setText("Print");
        this.Print.setToolTipText("This button will print the contents of the text area to the left.\n");
        this.Print.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.Print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.PrintActionPerformed(evt);
            }
        });
        this.file_print.setText("File");
        this.file_print.setToolTipText("This button will create a text file of the source files and execution");
        this.file_print.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.file_print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.file_printActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.Print).addGap(18, 18, 18).addComponent(this.file_print, -1, -1, 32767)).addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.Exit_button))).addContainerGap()));

        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.Print).addComponent(this.file_print)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addComponent(this.Exit_button).addContainerGap()));

        this.process_text.setColumns(20);
        this.process_text.setRows(5);
        this.process_text.setToolTipText("This text area will show the output of the compile, assemble, link and the result of the running of the  linked file.");
        this.process_output.setViewportView(this.process_text);

        this.studentName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                G_LiteUI.this.studentNameActionPerformed(evt);
            }
        });
        this.jLabel1.setText("Student Name");
        this.studentName.setText(System.getProperty("user.name"));

        this.textDirectory.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                G_LiteUI.this.onTextDirectoryChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                G_LiteUI.this.onTextDirectoryChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // G_LiteUI.this.onTextDirectoryChange();
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(this.process_output, -1, 420, 32767)
                                .addGap(37, 37, 37)
                                .addComponent(this.jPanel2, -2, -1, -2)
                                .addGap(22, 22, 22))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(this.Run_button).addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
                                                        .addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(this.Link_button)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(this.Run_file, -1, 172, 32767))
                                                        .addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(this.Assemble)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(this.S_file))
                                                        .addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(this.Compile_button)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                                                                        .addComponent(this.textDirectory, -1, 172, 32767)
                                                                        .addComponent(this.studentName, -1, 172, 32767)
                                                                        .addComponent(this.C_file))))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(this.labelUserDirectory)
                                                        .addComponent(this.jLabel1)
                                                        .addComponent(this.C_lang_chooser)
                                                        .addComponent(this.Assem_Lang_chooser))))
                                .addContainerGap(163, 32767)));

        jPanel1Layout.linkSize(0, new Component[]{this.Assemble, this.Compile_button, this.Link_button, this.Run_button});

        jPanel1Layout.linkSize(0, new Component[]{this.Assem_Lang_chooser, this.C_lang_chooser});
        // jpanel 1
        //.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.textDirectory, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.labelUserDirectory, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(50, 32767)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(this.textDirectory, -2, -1, -2)
                                                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3)
                                                                .addComponent(this.labelUserDirectory, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(this.studentName, -2, -1, -2)
                                                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3)
                                                                .addComponent(this.jLabel1, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(this.Compile_button)
                                                        .addComponent(this.C_file, -2, -1, -2)
                                                        .addComponent(this.C_lang_chooser)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(this.Assemble)
                                                                .addComponent(this.Assem_Lang_chooser))
                                                        .addComponent(this.S_file, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(this.Run_file, -2, -1, -2)
                                                        .addComponent(this.Link_button)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(this.Run_button).addGap(26, 26, 26)
                                                .addComponent(this.process_output, -2, 100, -2))
                                        .addComponent(this.jPanel2, Alignment.TRAILING, -2, -1, -2))));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));

        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));

        this.jPanel1.getAccessibleContext().setAccessibleName("CS252 UI Assistant (S16)");

        pack();
    }

    private void onTextDirectoryChange() {
        File f = new File(this.textDirectory.getText());
        if (!(f.exists() && f.isDirectory())) return;
        String assRegex = ".*\\.s";
        String cRegex = ".*\\.c";
        String myPath;
        for (File subFile : f.listFiles()) {
            if (subFile.getName().matches(cRegex)) {
                this.C_file.setText(subFile.getName());
                myPath = subFile.getPath();
                int endIndex = myPath.lastIndexOf("\\");
                this.workPath = myPath.substring(0, endIndex + 1);
            } else if (subFile.getName().matches(assRegex)) {
                this.S_file.setText(subFile.getName());
                myPath = subFile.getPath();
                int endIndex = myPath.lastIndexOf("\\");
                this.workPath = myPath.substring(0, endIndex + 1);
            }
        }
    }

    public int print(Graphics g, PageFormat pf, int pageIndex) {
        Font font = new Font("Font.MONOSPACED", 0, 12);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();
        if (this.pageBreaks == null) {
            int linesPerPage = (int) (pf.getImageableHeight() / lineHeight);
            int numBreaks = (this.lines.size() - 1) / linesPerPage;
            this.pageBreaks = new int[numBreaks];
            for (int b = 0; b < numBreaks; b++) {
                this.pageBreaks[b] = ((b + 1) * linesPerPage);
            }
        }
        if (pageIndex > this.pageBreaks.length) {
            return 1;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        int y = 0;
        int start = pageIndex == 0 ? 0 : this.pageBreaks[(pageIndex - 1)];
        int end = pageIndex == this.pageBreaks.length ? this.lines.size() : this.pageBreaks[pageIndex];
        for (int line = start; line < end; line++) {
            y += lineHeight;
            g.drawString((String) this.lines.get(line), 0, y);
        }
        return 0;
    }

    private void Compile_buttonActionPerformed(ActionEvent evt) {
        String cfile = '"' + this.workPath + this.C_file.getText() + '"';
        String outfile = '"' + this.workPath + "cout" + '"';
        String cs252 = this.workPath + this.batfile;
        File tmpFile = new File(cs252);
        boolean tmpGone;
        try {
            String Ccommand = this.fullcommand + outfile + " " + cfile;
            PrintWriter ostream = new PrintWriter(new FileWriter(tmpFile));
            ostream.println("@echo off");
            ostream.println(Ccommand);
            ostream.close();
            ProcessBuilder pb = new ProcessBuilder(new String[]{cs252});
            pb.redirectErrorStream(true);
            Process p = pb.start();
            InputStream inp = p.getInputStream();
            BufferedReader binp = new BufferedReader(new InputStreamReader(inp));
            String line = binp.readLine();
            while (line != null) {
                this.process_text.append(line + "\n");
                line = binp.readLine();
            }
            int result = p.waitFor();
            this.process_text.append("Compile Result: " + result + "\n");
            p.destroy();
            tmpGone = tmpFile.delete();
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    private void Exit_buttonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void C_lang_chooserActionPerformed(ActionEvent evt) {
        OpenActionPerformed(evt);
    }

    private void Assem_Lang_chooserActionPerformed(ActionEvent evt) {
        OpenActionPerformed(evt);
    }

    private void AssembleActionPerformed(ActionEvent evt) {
        String sfile = '"' + this.workPath + this.S_file.getText() + '"';
        String outfile = '"' + this.workPath + "sout" + '"';
        String cs252 = this.workPath + this.batfile;
        File tmpFile = new File(cs252);
        boolean tmpGone;
        try {
            String Acommand = this.fullcommand + outfile + " " + sfile;
            PrintWriter ostream = new PrintWriter(new FileWriter(tmpFile));
            ostream.println("@echo off");
            ostream.println(Acommand);
            ostream.close();
            ProcessBuilder pb = new ProcessBuilder(new String[]{cs252});
            pb.redirectErrorStream(true);
            Process p = pb.start();
            InputStream inp = p.getInputStream();
            BufferedReader binp = new BufferedReader(new InputStreamReader(inp));
            String line = binp.readLine();
            while (line != null) {
                this.process_text.append(line + "\n");
                line = binp.readLine();
            }
            int result = p.waitFor();
            this.process_text.append("Assembly Result: " + result + "\n");
            p.destroy();
            tmpGone = tmpFile.delete();
        } catch (IOException io) {

            System.out.println(io.getMessage());
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    private void Link_buttonActionPerformed(ActionEvent evt) {
        String cfile = '"' + this.workPath + "cout" + '"';
        String sfile = '"' + this.workPath + "sout" + '"';

        String option = " -T armulator-ram-hosted.ld";
        String cs252 = this.workPath + this.batfile;
        File tmpFile = new File(cs252);
        String rlfile = this.Run_file.getText();
        String outfile;
        boolean tmpGone;
        if (rlfile.equals("")) {
            outfile = '"' + this.workPath + "runit" + '"';
        } else {
            outfile = '"' + this.workPath + rlfile + '"';
        }
        try {
            String Lcommand = "arm-none-eabi-gcc -g -o " + outfile + " " + cfile;
            Lcommand = Lcommand + " " + sfile + " " + option;
            PrintWriter ostream = new PrintWriter(new FileWriter(tmpFile));
            ostream.println("@echo off");
            ostream.println(Lcommand);
            ostream.close();
            ProcessBuilder pb = new ProcessBuilder(new String[]{cs252});
            pb.redirectErrorStream(true);
            Process p = pb.start();
            InputStream inp = p.getInputStream();
            BufferedReader binp = new BufferedReader(new InputStreamReader(inp));
            String line = binp.readLine();
            while (line != null) {
                this.process_text.append(line + "\n");
                line = binp.readLine();
            }
            int result = p.waitFor();
            this.process_text.append("Link Result: " + result + "\n");
            if (result == 0) {
                if (rlfile.equals("")) {
                    this.Run_file.setText("runit");
                } else {
                    this.Run_file.setText(rlfile);
                }
            }
            p.destroy();
            tmpGone = tmpFile.delete();
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    private void Run_buttonActionPerformed(ActionEvent evt) {
        String cs252 = this.workPath + this.batfile;
        File tmpFile = new File(cs252);
        String rfile = this.Run_file.getText();
        String outfile;
        boolean tmpGone;
        if (rfile.equals("")) {
            outfile = '"' + this.workPath + "runit" + '"';
        } else {
            outfile = '"' + this.workPath + rfile + '"';
        }
        try {
            String Rcommand = "arm-none-eabi-run " + outfile;
            PrintWriter ostream = new PrintWriter(new FileWriter(cs252));
            ostream.println("@echo off");
            ostream.println(Rcommand);
            ostream.close();
            ProcessBuilder pb = new ProcessBuilder(new String[]{cs252});
            pb.redirectErrorStream(true);
            Process p = pb.start();
            InputStream inp = p.getInputStream();
            BufferedReader binp = new BufferedReader(new InputStreamReader(inp));
            this.process_text.setText("");
            String line = binp.readLine();
            while (line != null) {
                this.process_text.append(line + "\n");
                line = binp.readLine();
            }
            int result = p.waitFor();
            p.destroy();
            tmpGone = tmpFile.delete();
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }

    private String tab2spaces(String in) {
        StringBuilder expand = new StringBuilder();
        for (int index = 0; index < in.length(); index++) {
            if (in.charAt(index) == '\t') {
                expand.append(this.spaces.substring(index, this.spc[index] + index));
            } else {
                expand.append(in.charAt(index));
            }
        }
        return expand.toString();
    }

    private void initLines() {
        String cfile = this.workPath + this.C_file.getText();
        String sfile = this.workPath + this.S_file.getText();
        BufferedReader instream = null;

        Boolean didit = Boolean.valueOf(this.lines.add(this.studentName.getText()));
        didit = Boolean.valueOf(this.lines.add("\n"));
        didit = Boolean.valueOf(this.lines.add(this.process_text.getText()));

        didit = Boolean.valueOf(this.lines.add("\n ******************\n"));
        didit = Boolean.valueOf(this.lines.add(sfile));
        String linein;
        try {
            instream = new BufferedReader(new FileReader(sfile));
            while ((linein = instream.readLine()) != null) {
                didit = Boolean.valueOf(this.lines.add(tab2spaces(linein)));
            }
            instream.close();
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
        didit = Boolean.valueOf(this.lines.add("\n------------------\n"));
        didit = Boolean.valueOf(this.lines.add(cfile));
        try {
            instream = new BufferedReader(new FileReader(cfile));
            while ((linein = instream.readLine()) != null) {
                didit = Boolean.valueOf(this.lines.add(tab2spaces(linein)));
            }
            instream.close();
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
    }

    private void PrintActionPerformed(ActionEvent evt) {
        initLines();
        PrinterJob job = PrinterJob.getPrinterJob();
        PrintService printer = job.getPrintService();
        if (printer == null) {
            JOptionPane.showMessageDialog(this, "No Default Printer", "Printer Error", 0);

            return;
        }
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException pe) {
                System.out.println(pe.getMessage());
            }
        }
    }

    private void studentNameActionPerformed(ActionEvent evt) {
    }

    private void file_printActionPerformed(ActionEvent evt) {
        PrintWriter result_out = null;
        String result_file = this.workPath + "result.txt";

        initLines();
        try {
            result_out = new PrintWriter(new FileWriter(result_file));
            for (int i = 0; i < this.lines.size(); i++) {
                result_out.println((String) this.lines.get(i));
            }
        } catch (IOException e) {
            System.err.println("Trouble writing file: " + e);
        } finally {
            if (result_out != null) {
                result_out.close();
            }
        }
    }

    private void OpenActionPerformed(ActionEvent evt) {
        String userDirectory = this.textDirectory.getText();
        userDirectory = userDirectory.matches("\".*\"")
                ? userDirectory.substring(1, userDirectory.length() - 1)
                : userDirectory;
        File dir = new File(userDirectory);
        if (dir.exists() && dir.isDirectory()) {
            this.fileChooser.setCurrentDirectory(dir);
        }
        int returnVal = this.fileChooser.showOpenDialog(this);
        if (returnVal == 0) {
            File file = this.fileChooser.getSelectedFile();
            this.fileName = file.getName();
            String myPath = file.getPath();
            int endIndex = myPath.lastIndexOf("\\");
            this.workPath = myPath.substring(0, endIndex + 1);
            if (evt.getActionCommand().equalsIgnoreCase(this.C_lang)) {
                this.C_file.setText(this.fileName);
            }
            if (evt.getActionCommand().equalsIgnoreCase(this.A_lang)) {
                this.S_file.setText(this.fileName);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(G_LiteUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(G_LiteUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(G_LiteUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(G_LiteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new G_LiteUI().setVisible(true);
            }
        });
    }

    private JFileChooser fileChooser = new JFileChooser();
    private String fileName;
    private String workPath;
    private String C_lang = "C_language_file";
    private String A_lang = "Assembly_lang_file";
    private String fullcommand = "arm-none-eabi-gcc -g -c -o ";
    private String batfile = "cs.bat";
    private List<String> lines = new ArrayList();
    int[] pageBreaks;
    String spaces = "                                           ";
    int[] spc = {4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1};
}
