package ui.Hristovski.opj.feri;


import si.feri.opj.Hristovski.Hiking.Lokacija;
import si.feri.opj.Hristovski.Hiking.Plezalec;
import si.feri.opj.Hristovski.Hiking.Plezalisce;
import si.feri.opj.Hristovski.Hiking.PlezalnaSmer;
import si.feri.opj.Hristovski.Hiking.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GUI extends JFrame {


    private JMenu mainMenu;
    private JPanel Original;
    private JPanel PanelSmeri;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private JPanel fourthPanel;
    private JTextField textField1Smer;
    private JTextField ZadnjiPregled1;
    private JButton spremeniButtonSmeri;
    private JButton ustvariButtonSmeri;
    private JButton zbrisiButton;
    private JTextField fieldOznaka;
    private JTextField fieldSmeriTezavnost;
    private JRadioButton balvanskiRadioButtonSmeri;
    private JRadioButton visinskiRadioButtonSmeri;
    private JTextField textFieldLokNaziv;
    private JTextField textFieldLokKraj;
    private JTextField textFieldLokIme;
    private JTextField textFieldLokDrzava;
    private JRadioButton balvanskiRadioButtonLok;
    private JRadioButton visinskiRadioButtonLok;
    private JButton ustvariButtonLok;
    private JButton spremeniButtonLok;
    private JButton zbrisiButtonLok;
    private JTextField textFieldPlezalecIme;
    private JTextField textFieldPlezalecPriimek;
    private JButton spremeniButtonPlezalec;
    private JButton zbrisiButtonPlezalec;
    private JButton ustvariButtonPlezalec;
    private JTextField textFieldPlezalecImePlezaj;
    private JTextField textFieldPlezalecPriimekPlezaj;
    private JButton plezajButton;
    private JTextField textFieldNazivPCP;
    private JRadioButton balvanskiRadioButtonPCP;
    private JRadioButton visinskiRadioButtonPCP;
    private JCheckBox checkBoxPCP;
    private JButton odstraniButtonPCP;
    private JButton dodajButtonPCP;
    private JComboBox IzberiImeSmeri;
    private JComboBox comboBoxIzberiLok;
    private JComboBox comboBoxPlezalecIzberi;
    private JComboBox comboBoxIzberiPCP;
    private JTextField textFieldPlezalecPlezalnaSmerPlezaj;
    private JComboBox comboBoxIzberiPCPCP;
    private JTextField textFieldTelefonPCPCP;
    private JButton dodajButtonPCPCP;
    private JButton odstraniButtonPCPCP;
    private JLabel ImeSmeri;
    private JLabel zadPresmeri;
    private JLabel TezavSmeri;
    private JLabel TipsmeriSmer;
    private JLabel OznakaLabelSmeri;
    private JLabel LabelIzveriIme;
    private JComboBox JComboBoxPlezalecStLicenca;
    private JTextField JTextKrajPCP;
    private JTextField JTextDrzavaPCP;
    private JTextField textFieldPlezalecStLicenca;
    private JList listPC;
    private JComboBox ComboBoxIzberiLokacijo;
    private JTextField KapacitetPC;
    private JComboBox izberiPLEzaliscePCPdodaj;
    private JComboBox IzberiSMERzaDodajPCP;
    private JLabel a;
    private JButton dodajPCPPlezalisce;
    private JButton odstraniDodajPCP;
    private JComboBox SmercomboZaDodajanje;
    private JComboBox plezalisceCombozaDoda;
    private JButton cardBtn1;
    private JButton cardBtn2;
    private JButton cardBtn3;

    ArrayList<PlezalnaSmer> SmeriList = new ArrayList();
    ArrayList<Lokacija> LokList = new ArrayList();
    ArrayList<Plezalec> PlezalecList = new ArrayList();
    ArrayList<Plezalisce> PlezalisceList = new ArrayList();
    ArrayList<PlezalniCenter> Smeri = new ArrayList();
    ArrayList<PlezalnaSmer> DodadeniSmerovi = new ArrayList();


    public GUI() {
        setContentPane(Original);
        setTitle("Dobrodošli");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        DefaultListModel dlmSMERI = new DefaultListModel();
        listPC.setModel(dlmSMERI);
        ustvariButtonSmeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (balvanskiRadioButtonSmeri.isSelected()) {
                    SmeriList.add(new PlezalnaSmer(Integer.parseInt(fieldOznaka.getText()),
                            textField1Smer.getText(), fieldSmeriTezavnost.getText(), LocalDate.parse(ZadnjiPregled1.getText()), TipSmeri.BALVANSKI));
                } else {
                    SmeriList.add(new PlezalnaSmer(Integer.parseInt(fieldOznaka.getText()),
                            textField1Smer.getText(), fieldSmeriTezavnost.getText(), LocalDate.parse(ZadnjiPregled1.getText()), TipSmeri.VISINSKA));
                }

                IzberiImeSmeri.removeAllItems();
                IzberiSMERzaDodajPCP.removeAllItems();
                for (int i = 0; i < SmeriList.size(); i++) {
                    IzberiImeSmeri.addItem(SmeriList.get(i).getIme());
                    if (DodadeniSmerovi.size() > 0 && !DodadeniSmerovi.get(i).getIme().equals(SmeriList.get(i).getIme())) {
                        IzberiSMERzaDodajPCP.addItem(SmeriList.get(i).getIme());
                    } else {
                        IzberiSMERzaDodajPCP.addItem(SmeriList.get(i).getIme());
                    }
                }

            }
        });

        IzberiImeSmeri.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < SmeriList.size(); i++) {
                    if (SmeriList.get(i).getIme().equals(IzberiImeSmeri.getSelectedItem().toString())) {
                        textField1Smer.setText(SmeriList.get(i).getIme());
                        ZadnjiPregled1.setText(String.valueOf(SmeriList.get(i).getZadnjiPregled()));
                        fieldSmeriTezavnost.setText(SmeriList.get(i).getTezavnost());
                        fieldOznaka.setText(String.valueOf(SmeriList.get(i).getOznaka()));
                        if (SmeriList.get(i).getTipSmeri() == TipSmeri.BALVANSKI) {
                            balvanskiRadioButtonSmeri.setSelected(true);
                            visinskiRadioButtonSmeri.setSelected(false);
                        } else {
                            balvanskiRadioButtonSmeri.setSelected(false);
                            visinskiRadioButtonSmeri.setSelected(true);
                        }
                    }

                }

                super.mouseClicked(e);
            }
        });
        zbrisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < SmeriList.size(); i++) {
                    if (SmeriList.get(i).getIme().equals(IzberiImeSmeri.getSelectedItem().toString())) {
                        System.out.println(IzberiImeSmeri.getSelectedItem().toString());
                        SmeriList.remove(i);
                        IzberiImeSmeri.removeAllItems();
                        IzberiSMERzaDodajPCP.removeAllItems();
                        for (int a = 0; a < SmeriList.size(); a++) {
                            IzberiImeSmeri.addItem(SmeriList.get(a).getIme());
                            if (DodadeniSmerovi.size() > 0 && !DodadeniSmerovi.get(a).getIme().equals(SmeriList.get(a).getIme())) {

                                IzberiSMERzaDodajPCP.addItem(SmeriList.get(a).getIme());
                            } else {
                                IzberiSMERzaDodajPCP.addItem(SmeriList.get(a).getIme());
                            }


                        }
                    }
                    ///set text na site " null "
                }
            }
        });
        spremeniButtonSmeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < SmeriList.size(); i++) {
                    if (SmeriList.get(i).getIme().equals(IzberiImeSmeri.getSelectedItem().toString())) {
                        SmeriList.get(i).setIme(textField1Smer.getText());
                        SmeriList.get(i).setOznaka(Integer.parseInt(fieldOznaka.getText()));
                        SmeriList.get(i).setZadnjiPregled(LocalDate.parse(ZadnjiPregled1.getText()));
                        SmeriList.get(i).setTezavnost(fieldSmeriTezavnost.getText());
                        if (balvanskiRadioButtonSmeri.isSelected()) {
                            SmeriList.get(i).setSmer(TipSmeri.BALVANSKI);
                        } else {
                            SmeriList.get(i).setSmer(TipSmeri.VISINSKA);
                        }
                        System.out.println(SmeriList.get(i));
                        IzberiImeSmeri.removeAllItems();
                        for (int a = 0; a < SmeriList.size(); a++) {
                            IzberiImeSmeri.addItem(SmeriList.get(a).getIme());
                        }
                    }
                }
            }
        });

        //Tuka pocnuva Lokacija


        ustvariButtonLok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (balvanskiRadioButtonLok.isSelected()) {
                    LokList.add(new Lokacija(textFieldLokNaziv.getText(), textFieldLokKraj.getText(), TipSmeri.BALVANSKI, textFieldLokIme.getText(), textFieldLokDrzava.getText()));
                } else {
                    LokList.add(new Lokacija(textFieldLokNaziv.getText(), textFieldLokKraj.getText(), TipSmeri.VISINSKA, textFieldLokIme.getText(), textFieldLokDrzava.getText()));
                }

                comboBoxIzberiLok.removeAllItems();
                ComboBoxIzberiLokacijo.removeAllItems();
                for (int i = 0; i < LokList.size(); i++) {
                    comboBoxIzberiLok.addItem(LokList.get(i).getNaziv());
                    ComboBoxIzberiLokacijo.addItem(LokList.get(i).getNaziv());
                }
            }
        });
        comboBoxIzberiLok.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < LokList.size(); i++) {
                    if (LokList.get(i).getNaziv() == comboBoxIzberiLok.getSelectedItem()) {
                        textFieldLokNaziv.setText(LokList.get(i).getNaziv());
                        textFieldLokKraj.setText(LokList.get(i).getKraj());
                        textFieldLokIme.setText(LokList.get(i).getIme());
                        textFieldLokDrzava.setText(LokList.get(i).getDrzava());
                        if (LokList.get(i).getSmer() == TipSmeri.BALVANSKI) {
                            balvanskiRadioButtonLok.setSelected(true);
                            visinskiRadioButtonLok.setSelected(false);
                        } else {
                            balvanskiRadioButtonLok.setSelected(false);
                            visinskiRadioButtonLok.setSelected(true);
                        }
                    }
                }
                super.mouseClicked(e);
            }
        });
        spremeniButtonLok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < LokList.size(); i++) {
                    if (LokList.get(i).getNaziv().equals(comboBoxIzberiLok.getSelectedItem().toString())) {
                        LokList.get(i).setNaziv(textFieldLokNaziv.getText());
                        LokList.get(i).setKraj(textFieldLokKraj.getText());
                        LokList.get(i).setDrzava(textFieldLokDrzava.getText());
                        if (balvanskiRadioButtonLok.isSelected()) {
                            LokList.get(i).setSmer(TipSmeri.BALVANSKI);
                        } else {
                            LokList.get(i).setSmer(TipSmeri.VISINSKA);
                        }
                        comboBoxIzberiLok.removeAllItems();
                        ComboBoxIzberiLokacijo.removeAllItems();
                        for (int a = 0; a < LokList.size(); a++) {
                            comboBoxIzberiLok.addItem(LokList.get(a).getNaziv());
                            ComboBoxIzberiLokacijo.addItem(LokList.get(a).getNaziv());

                        }
                    }
                }
            }
        });
        zbrisiButtonLok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < LokList.size(); i++) {
                    if (LokList.get(i).getNaziv().equals(comboBoxIzberiLok.getSelectedItem().toString())) {
                        LokList.remove(i);

                        comboBoxIzberiLok.removeAllItems();
                        ComboBoxIzberiLokacijo.removeAllItems();
                        for (int a = 0; a < LokList.size(); a++) {
                            comboBoxIzberiLok.addItem(LokList.get(a).getNaziv());
                            ComboBoxIzberiLokacijo.addItem(LokList.get(a).getNaziv());
                        }
                    }
                    ///set text na site " null "
                }
            }
        });



        /*PLEZALEC*/

        ustvariButtonPlezalec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PlezalecList.add(new Plezalec(textFieldPlezalecIme.getText(),
                        textFieldPlezalecPriimek.getText(), Integer.parseInt(textFieldPlezalecStLicenca.getText())));

                comboBoxPlezalecIzberi.removeAllItems();
                for (int i = 0; i < PlezalecList.size(); i++) {
                    comboBoxPlezalecIzberi.addItem(PlezalecList.get(i).getIme());
                }
            }
        });


        comboBoxPlezalecIzberi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < PlezalecList.size(); i++) {
                    if (PlezalecList.get(i).getIme() == comboBoxPlezalecIzberi.getSelectedItem()) {
                        textFieldPlezalecIme.setText(PlezalecList.get(i).getIme());
                        textFieldPlezalecPriimek.setText(PlezalecList.get(i).getPriimek());
                        textFieldPlezalecStLicenca.setText(String.valueOf(PlezalecList.get(i).getStevilkaLicence())); //Da se proveri tuka dali e vo red deka barase String toa bes int
                    }                                                                                                 //I mu staviv String.valueOf da se pretvori vo String
                }

                super.mouseClicked(e);
            }
        });


        zbrisiButtonPlezalec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < PlezalecList.size(); i++) {
                    if (PlezalecList.get(i).getIme().equals(comboBoxPlezalecIzberi.getSelectedItem().toString())) {
                        System.out.println(comboBoxIzberiLok.getSelectedItem().toString());
                        PlezalecList.remove(i);
                        comboBoxPlezalecIzberi.removeAllItems();
                        for (int a = 0; a < PlezalecList.size(); a++) {
                            comboBoxPlezalecIzberi.addItem(PlezalecList.get(a).getIme());
                        }
                    }
                }
            }
        });


        spremeniButtonPlezalec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < PlezalecList.size(); i++) {
                    if (PlezalecList.get(i).getIme().equals(comboBoxPlezalecIzberi.getSelectedItem().toString())) {
                        PlezalecList.get(i).setIme(textFieldPlezalecIme.getText());
                        PlezalecList.get(i).setPriimek(textFieldPlezalecPriimek.getText());
                        PlezalecList.get(i).setStevilkaLicence(Integer.parseInt(textFieldPlezalecStLicenca.getText()));
                        comboBoxPlezalecIzberi.removeAllItems();
                        for (int a = 0; a < PlezalecList.size(); a++) {
                            comboBoxPlezalecIzberi.addItem(PlezalecList.get(a).getIme());
                        }
                    }
                }
            }
        });

        //Plezalisce


//        dodajButtonPCP.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                boolean daIliNe = checkBoxPCP.isSelected();
//                if (balvanskiRadioButtonPCP.isSelected()) {
//                    Plezalisce pl=new Plezalisce();
//                    pl.setJeUrejeno(daIliNe);
//                    pl.setNaziv(textFieldNazivPCP.getText());
//                    pl.setKraj(JTextKrajPCP.getText());
//                    pl.setDrzava(textFieldNazivPCP.getText());
//                    pl.setSmer(TipSmeri.BALVANSKI);
//                    PlezalisceList.add(pl);
//                } else {
//                    PlezalisceList.add(new Plezalisce(textFieldNazivPCP.getText(), JTextKrajPCP.getText(), daIliNe, TipSmeri.VISINSKA));
//
//                }
//
//                comboBoxIzberiPCP.removeAllItems();
//                for (int a = 0; a < PlezalisceList.size(); a++) {
//                    System.out.println(PlezalisceList.get(a).getNaziv());
//                    System.out.println(PlezalisceList.get(a).getPlezalneSmeri());
//                    comboBoxIzberiPCP.addItem(PlezalisceList.get(a).getNaziv());
//                }
//            }
//        });


        odstraniButtonPCP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < PlezalisceList.size(); i++) {
                    if (PlezalisceList.get(i).getNaziv().equals(comboBoxIzberiPCP.getSelectedItem().toString())) {
                        PlezalisceList.remove(i);
                        izberiPLEzaliscePCPdodaj.removeAllItems();
                        comboBoxIzberiPCP.removeAllItems();
                        for (int a = 0; a < PlezalisceList.size(); a++) {
                            comboBoxIzberiPCP.addItem(PlezalisceList.get(a).getNaziv());
                            izberiPLEzaliscePCPdodaj.addItem(PlezalisceList.get(a).getNaziv());
                        }
                    }
                }
            }
        });

        comboBoxIzberiPCP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < PlezalisceList.size(); i++) {
                    System.out.println(PlezalisceList.get(i).getNaziv());
                    if (comboBoxIzberiPCP.getSelectedItem().toString().equals(PlezalisceList.get(i).getIme())) {
                        textFieldNazivPCP.setText(PlezalisceList.get(i).getNaziv());
                        JTextKrajPCP.setText(String.valueOf(PlezalisceList.get(i).getKraj()));
                        JTextDrzavaPCP.setText(PlezalisceList.get(i).getDrzava());
                        if (PlezalisceList.get(i).getSmer() == TipSmeri.BALVANSKI) {
                            balvanskiRadioButtonPCP.setSelected(true);
                            visinskiRadioButtonPCP.setSelected(false);
                        } else {
                            balvanskiRadioButtonPCP.setSelected(false);
                            visinskiRadioButtonPCP.setSelected(true);
                        }
                    }

                }
                super.mouseClicked(e);
            }
        });


        dodajButtonPCP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean daIliNe = checkBoxPCP.isSelected();
                if (balvanskiRadioButtonPCP.isSelected()) {
                    PlezalisceList.add(new Plezalisce(textFieldNazivPCP.getText(), JTextKrajPCP.getText(), daIliNe, TipSmeri.BALVANSKI, JTextDrzavaPCP.getText()));
                } else {
                    PlezalisceList.add(new Plezalisce(textFieldNazivPCP.getText(), JTextKrajPCP.getText(), daIliNe, TipSmeri.VISINSKA, JTextDrzavaPCP.getText()));
                }

                comboBoxIzberiPCP.removeAllItems();
                izberiPLEzaliscePCPdodaj.removeAllItems();
                for (int i = 0; i < PlezalisceList.size(); i++) {
                    comboBoxIzberiPCP.addItem(PlezalisceList.get(i).getNaziv());
                    izberiPLEzaliscePCPdodaj.addItem(PlezalisceList.get(i).getNaziv());

                }
            }
        });
        dodajButtonPCPCP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < LokList.size(); i++) {
                    String asd = ComboBoxIzberiLokacijo.getSelectedItem().toString();
                    if (asd.equals(LokList.get(i).getNaziv())) {
                        Smeri.add(new PlezalniCenter(LokList.get(i).getNaziv(), Integer.parseInt(KapacitetPC.getText()), LokList.get(i).getKraj(), LokList.get(i).getSmer(), textFieldTelefonPCPCP.getText()));
                        System.out.println(Smeri.get(0).toString());
                        comboBoxIzberiPCPCP.removeAllItems();
                        for (int a = 0; a < Smeri.size(); i++) {
                            comboBoxIzberiPCPCP.addItem(Smeri.get(i).getNaziv());
                        }
                        break;
                    }
                }
            }
        });
        comboBoxIzberiPCPCP.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {


                super.mouseClicked(e);
            }
        });
        odstraniButtonPCPCP.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {

                for (int i = 0; i < Smeri.size(); i++) {
                    if (Smeri.get(i).getNaziv().equals(comboBoxIzberiPCPCP.getSelectedItem().toString())) {
                        Smeri.remove(i);
                        comboBoxIzberiPCPCP.removeAllItems();
                        for (int a = 0; a < Smeri.size(); i++) {
                            comboBoxIzberiPCPCP.addItem(Smeri.get(i).getNaziv());
                        }
                        break;
                    }

                }
                super.mouseClicked(e);
            }
        });

        dodajPCPPlezalisce.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int p = 0;


                for (int i = 0; i < SmeriList.size(); i++) {
                    if (p == 0) {
                        if (SmeriList.get(i).getIme().equals(IzberiSMERzaDodajPCP.getSelectedItem().toString())) {

                            for (int a = 0; a < PlezalisceList.size(); a++) {
                                if (PlezalisceList.get(a).getNaziv().equals(izberiPLEzaliscePCPdodaj.getSelectedItem().toString())) {

                                    try {
                                        PlezalisceList.get(a).dodajPlezalnoSmer(SmeriList.get(i));
                                    } catch (TipSmeriException ex) {
                                        ex.printStackTrace();
                                    }
                                    DodadeniSmerovi.add(SmeriList.get(i));
                                    dlmSMERI.addElement(SmeriList.get(i).getIme());

                                    IzberiSMERzaDodajPCP.removeAllItems();
                                    for (int c = 0; c < SmeriList.size(); c++) {
                                        if (DodadeniSmerovi.size() <= c && c != 0) {
                                            IzberiSMERzaDodajPCP.addItem(SmeriList.get(c).getIme());
                                        } else if (!DodadeniSmerovi.get(c).getIme().equals(SmeriList.get(c).getIme())) {
                                            IzberiSMERzaDodajPCP.addItem(SmeriList.get(c).getIme());
                                        }
                                        p++;
                                    }

                                }

                            }

                        }


                    }
                }
            }
        });
        izberiPLEzaliscePCPdodaj.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                IzberiSMERzaDodajPCP.removeAllItems();

                for (int i = 0; i < PlezalisceList.size(); i++) {
                    if (PlezalisceList.get(i).getNaziv().equals(izberiPLEzaliscePCPdodaj.getSelectedItem().toString())) {
                        dlmSMERI.removeAllElements();
                        int a = PlezalisceList.get(i).getPlezalneSmeri().size();
                        for (int c = 0; c < a; c++) {
                            dlmSMERI.addElement(PlezalisceList.get(i).getPlezalneSmeri().get(c).getIme());
                        }


                    }
                }
                int s=0;
                for (int x = 0; x < SmeriList.size(); x++) {
                    for (int index=0;index<DodadeniSmerovi.size();index++) {
                        if (!DodadeniSmerovi.get(index).getIme().equals(SmeriList.get(x).getIme())&& DodadeniSmerovi.size()>0) {
                            IzberiSMERzaDodajPCP.addItem(SmeriList.get(x).getIme());
                            s++;
                        }
                    }
                    if (DodadeniSmerovi.size()==0&& s==0){
                        IzberiSMERzaDodajPCP.addItem(SmeriList.get(x).getIme());

                    }

                }


                if (DodadeniSmerovi.size() != 1) {
                    IzberiSMERzaDodajPCP.removeAllItems();
                    s = 0;
                    for (int x = 0; x < SmeriList.size(); x++) {
                        for (int index = 0; index < DodadeniSmerovi.size(); index++) {
                            if (!DodadeniSmerovi.get(index).getIme().equals(SmeriList.get(x).getIme()) && DodadeniSmerovi.get(index).getIme().equals(null)&& SmeriList.get(x).getIme().equals(null)) {
                                IzberiSMERzaDodajPCP.addItem(SmeriList.get(x).getIme());
                                s++;
                            }
                        }


                    }
                }
                super.mouseClicked(e);
            }
        });
        odstraniDodajPCP.addActionListener(new ActionListener() {
            /**
             * * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed (ActionEvent e){
                IzberiSMERzaDodajPCP.removeAllItems();
                int s=0;
                for (int x = 0; x < SmeriList.size(); x++) {
                    for (int index=0;index<DodadeniSmerovi.size();index++) {
                        if (!DodadeniSmerovi.get(index).getIme().equals(SmeriList.get(x).getIme())) {
                            IzberiSMERzaDodajPCP.addItem(SmeriList.get(x).getIme());
                            s++;
                        }
                    }
                    if (DodadeniSmerovi.size()==0&& s==0){
                        IzberiSMERzaDodajPCP.addItem(SmeriList.get(x).getIme());

                    }

                }
                for (int i = 0; i < DodadeniSmerovi.size(); i++) {
                    if (listPC.getSelectedValue().toString().equals(DodadeniSmerovi.get(i).getIme())) {
                        DodadeniSmerovi.remove(i);
                        dlmSMERI.remove(i);

                    }
                }
                IzberiSMERzaDodajPCP.removeAllItems();
                s=0;
                for (int i = 0; i < SmeriList.size(); i++) {
                    for (int index=0;index<DodadeniSmerovi.size();index++) {
                        if (!DodadeniSmerovi.get(index).getIme().equals(SmeriList.get(i).getIme())) {
                            IzberiSMERzaDodajPCP.addItem(SmeriList.get(i).getIme());
                            s++;
                        }
                    }
                    if (DodadeniSmerovi.size()==0&& s==0){
                        IzberiSMERzaDodajPCP.addItem(SmeriList.get(i).getIme());

                    }

                }
            }
        });
    }



//2017-07-13


}


class Zagonski {
    public static void main(String[] args) {
        new GUI();

    }

}


