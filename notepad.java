import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.io.*;

class menu extends Frame implements ActionListener {
  MenuBar mb;
  Menu m1, m2, m3, m4, m5;
  TextArea t1;
  int flag;
  MenuItem i1, i2, i3, i4, i5, i6, i7, i8, i9, i0, i11, i12, i13, i14, i15, i16, i17,
      i18, i19;
  String str2 = "";
  String str1, f, d;

  public menu() {
    super("NOTEPAD");
    t1 = new TextArea();
    mb = new MenuBar();
    setMenuBar(mb);
    m1 = new Menu("FILE");
    mb.add(m1);
    m2 = new Menu("EDIT");
    mb.add(m2);
    m3 = new Menu("FORMAT");
    mb.add(m3);
    m4 = new Menu("VIEW");
    mb.add(m4);
    m5 = new Menu("HELP");
    mb.add(m5);
    i1 = new MenuItem("New");
    m1.add(i1);
    i2 = new MenuItem("Open");
    m1.add(i2);
    i3 = new MenuItem("Save as");
    m1.add(i3);
    i4 = new MenuItem("Save");
    m1.add(i4);
    i14 = new MenuItem("Exit");
    m1.add(i14);
    i5 = new MenuItem("Undo");
    m2.add(i5);
    i6 = new MenuItem("Cut ctrl+x");
    m2.add(i6);
    i7 = new MenuItem("Copy ctrl+c");
    m2.add(i7);
    i8 = new MenuItem("Paste ctrl+v");
    m2.add(i8);
    i9 = new MenuItem("Delete del");
    m2.add(i9);
    i0 = new MenuItem("Find");
    m2.add(i0);
    i16 = new MenuItem("Find next");
    m2.add(i16);
    i18 = new MenuItem("Select all");
    m2.add(i18);
    i15 = new MenuItem("Go to");
    m2.add(i15);
    i11 = new MenuItem("Replace");
    m2.add(i11);
    i17 = new MenuItem("Date/Time");
    m4.add(i17);
    i12 = new MenuItem("Font");
    m3.add(i12);
    i13 = new MenuItem("Help topics");
    m5.add(i13);
    i19 = new MenuItem("About Notepad");
    m5.add(i19);
    add(t1);
    i1.addActionListener(this);
    i2.addActionListener(this);
    i3.addActionListener(this);
    i4.addActionListener(this);
    i5.addActionListener(this);
    i6.addActionListener(this);
    i7.addActionListener(this);
    i8.addActionListener(this);
    i9.addActionListener(this);
    i0.addActionListener(this);
    i11.addActionListener(this);
    i12.addActionListener(this);
    i13.addActionListener(this);
    i14.addActionListener(this);
    i15.addActionListener(this);
    i16.addActionListener(this);
    i17.addActionListener(this);
    i18.addActionListener(this);
    i19.addActionListener(this);
    wind n = new wind(this);
    addWindowListener(n);
  }

  public void actionPerformed(ActionEvent ae) {
    String str = ae.getActionCommand();
    if (str.equals("New")) {
      t1.setText("");
    }
    if (str.equals("Open")) {
      try {
        char w[] = new char[1];
        FileDialog f = new FileDialog(this, "OPEN", FileDialog.LOAD);
        f.setVisible(true);
        str = f.getFile();
        String str3 = f.getDirectory();
        FileInputStream k = new FileInputStream(str3 + "/" + str);
        int r = k.available();
        int o = 0;
        while (o < r) {
          w[0] = (char) k.read();
          str = str + new String(w);
          o++;
        }
        k.close();
      } catch (IOException e) {
      }
      t1.setText(str);

    }
    if (str.equals("Save")) {
      if (flag == 0) {
        FileDialog fd = new FileDialog(this, "save as", FileDialog.SAVE);
        fd.setVisible(true);
        f = fd.getFile();
        d = fd.getDirectory();
        setTitle(f);
        flag = 1;
      }
      if (flag == 1) {
        try {
          str = t1.getText();
          FileOutputStream k = new FileOutputStream(d + "/" + f);
          byte b[] = str.getBytes();
          for (int i = 0; i < b.length; i++) {
            k.write(b[i]);
          }
          k.close();
        } catch (IOException e) {
          setTitle("UNTITLED.TXT");
        }
      }
    }
    if (str.equals("Save as")) {
      try {
        FileDialog f = new FileDialog(this, "save as", FileDialog.SAVE);
        f.setVisible(true);
        str = t1.getText();
        str1 = f.getFile();
        String str3 = f.getDirectory();
        setTitle(str1);
        FileOutputStream k = new FileOutputStream(str3 + "/" + str1);
        byte b[] = str.getBytes();
        flag = 1;
        for (int i = 0; i < b.length; i++) {
          k.write(b[i]);
        }
        k.close();
      } catch (IOException e) {
        setTitle("UNTITLED.TXT");
      }
    }

    if (str.equals("Delete del")) {
      str1 = t1.getSelectedText();
      t1.replaceRange("", t1.getText().indexOf(str1), t1.getText().indexOf(str1) + str1.length());
    }
    if (str.equals("Cut ctrl+x")) {
      str1 = t1.getSelectedText();
      if (t1.getText().indexOf(str1) == 0) {
        cut c = new cut(this, "cut");
        c.setVisible(true);
        c.setSize(150, 100);
      } else
        t1.replaceRange("", t1.getText().indexOf(str1), t1.getText().indexOf(str1) + str1.length());
    }
    if (str.equals("Copy ctrl+c")) {
      str1 = t1.getSelectedText();
      if (t1.getText().indexOf(str1) == 0) {
        cut1 c = new cut1(this, "copy");
        c.setVisible(true);
        c.setSize(150, 100);
      }
    }
    if (str.equals("Paste ctrl+v")) {
      t1.append(str1);
    }
    if (str.equals("Exit")) {
      this.dispose();
    }
    if (str.equals("Undo")) {
      t1.append(str1);
    }
    if (str.equals("Find")) {
      find f = new find(this, "FIND");
      f.setSize(150, 150);
      f.setVisible(true);
    }
    if (str.equals("Find next")) {
      find1 f1 = new find1(this, "FIND NEXT");
      f1.setSize(150, 150);
      f1.setVisible(true);
    }
    if (str.equals("Date/Time")) {
      Date date = new Date();
      t1.setText(t1.getText() + date);
    }
    if (str.equals("Replace")) {
      replace r = new replace(this, "REPLACE");
      r.setVisible(true);
      r.setSize(150, 150);
    }
    if (str.equals("Go to")) {
      goto1 g = new goto1(this, "GO TO");
      g.setVisible(true);
      g.setSize(100, 100);
    }
    if (str.equals("Font")) {
      samplefont d = new samplefont(this, "FONT");
      d.setVisible(true);
      d.setSize(150, 300);
    }
    if (str.equals("Select all")) {
      str1 = t1.getText();
      t1.select(0, str1.length());
    }
    if (str.equals("Help topics")) {
      helptopics z = new helptopics(this, "helptopics");
      z.setSize(400, 250);
      z.setVisible(true);
    }
    if (str.equals("About Notepad")) {
      anotepad z = new anotepad(this, "                                ABOUT NOTEPAD");
      z.setSize(300, 150);
      z.setVisible(true);
    }
  }
}

class wind extends WindowAdapter {
  menu n;

  public wind(menu n) {
    this.n = n;
  }

  public void windowClosing(WindowEvent we) {
    n.dispose();
  }
}

class find extends Dialog implements ActionListener {
  int t;
  menu n1;
  TextField t1;
  Button b1, b2, b3, b4;
  Label l1;
  String str, str1;

  public find(menu n, String str) {
    super(n, str, true);
    this.n = n;
    setLayout(new FlowLayout());
    l1 = new Label("Find What");
    t1 = new TextField(15);
    b1 = new Button("find");
    b3 = new Button("find next");
    b4 = new Button("ok");
    add(l1);
    add(t1);
    add(b1);
    add(b3);
    add(b4);
    t = 0;
    b1.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    addWindowListener(new foo1(this));
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    if (str.equals("find")) {
      str1 = t1.getText();
      t = n.t1.getText().indexOf(str1);
      n.t1.select(t, t + str1.length());
    }
    if (str.equals("find next")) {
      str1 = t1.getText();
      t = n.t1.getText().indexOf(str1, t + str1.length());
      n.t1.select(t, t + str1.length());
    }
    if (str.equals("ok")) {
      setVisible(false);
    }
  }
}

class foo1 extends WindowAdapter {
  find f;

  foo1(find f) {
    this.f = f;
  }

  public void windowClosing(WindowEvent we) {
    f.dispose();
  }
}

class replace extends Dialog implements ActionListener {
  int t;
  menu n;
  TextField t1, t2;
  Label l1, l2;
  Button b1, b4, b2, b3;
  String str, str1, str2;

  public replace(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    t1 = new TextField(15);
    t2 = new TextField(15);
    l1 = new Label("Replace What");
    l2 = new Label("Replace With");
    b2 = new Button("replace");
    b3 = new Button("replace next");
    b1 = new Button("ok");
    b4 = new Button("cancel");
    add(l1);
    add(t1);
    add(b2);
    add(l2);
    add(t2);
    t = 0;
    add(b3);
    add(b1);
    add(b4);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    addWindowListener(new cool1(this));
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    str2 = t1.getText();
    if (str.equals("replace")) {
      str1 = t1.getText();
      t = n.t1.getText().indexOf(str1);
      n.t1.replaceRange(t2.getText(), t, t + str1.length());
    }
    if (str.equals("replace next")) {
      str1 = t1.getText();
      while (true) {
        t = n.t1.getText().indexOf(str1, t + str1.length());
        if (t < 0) {
          break;
        }
        n.t1.replaceRange(t2.getText(), t, t + str1.length());
      }
    }
    if (str.equals("ok")) {
      setVisible(false);
    }
    if (str.equals("cancel")) {
      n.t1.setText(str2);
      setVisible(false);
    }
  }
}

class cool1 extends WindowAdapter {
  replace f;

  cool1(replace f) {
    this.f = f;
  }

  public void windowClosing(WindowEvent we) {
    f.dispose();
  }
}

class samplefont extends Dialog implements ItemListener, ActionListener {
  menu n;
  Color c1, c2;
  Label l1, l2, l3, l4;
  Button b1, b2;
  Choice os, os1, os2, os3;
  String str, str1, str2, str3;
  Font f;
  int i;

  public samplefont(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    b1 = new Button("ok");
    b2 = new Button("cancel");
    os = new Choice();
    Label l1 = new Label("FONT STYLE");
    Label l2 = new Label("FONT SIZE");
    Label l3 = new Label("BACK GROUND COLOR");
    Label l4 = new Label("FORE GROUND COLOR");
    os.add("Plain");
    os.add("Bold");
    os.add("Italic");
    os.add("Bold Italic");
    add(l1);
    add(os);
    os.addItemListener(this);
    os1 = new Choice();
    os1.add("36");
    os1.add("9");
    os1.add("10");
    os1.add("11");
    os1.add("12");
    os1.add("14");
    os1.add("16");
    os1.add("18");
    os1.add("20");
    os1.add("22");
    os1.add("24");
    os1.add("26");
    os1.add("28");
    os1.add("8");
    os1.add("48");
    os1.add("72");
    add(l2);
    add(os1);
    os1.addItemListener(this);
    os2 = new Choice();
    os2.add("red");
    os2.add("black");
    os2.add("cyan");
    os2.add("blue");
    os2.add("darkgrey");
    os2.add("green");
    os2.add("lightgray");
    os2.add("white");
    os2.add("magenta");
    os2.add("yellow");
    os2.add("orange");
    os2.add("pink");
    os2.add("gray");
    add(l3);
    add(os2);
    os2.addItemListener(this);
    os3 = new Choice();
    os3.add("black");
    os3.add("blue");
    os3.add("cyan");
    os3.add("darkgrey");
    os3.add("magenta");
    os3.add("orange");
    os3.add("pink");
    os3.add("red");
    os3.add("grey");
    os3.add("green");
    os3.add("lightgrey");
    os3.add("white");
    os3.add("yellow");
    add(l4);
    add(os3);
    add(b1);
    add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);
    os3.addItemListener(this);
    addWindowListener(new kool1(this));
  }

  public void itemStateChanged(ItemEvent ie) {
    str = os.getSelectedItem();
    str1 = os1.getSelectedItem();
    str2 = os2.getSelectedItem();
    str3 = os3.getSelectedItem();
    i = Integer.parseInt(str1);
    if (str.equals("Bold")) {
      f = new Font("Dialog", Font.BOLD, i);
      n.t1.setFont(f);
    }
    if (str.equals("Italic")) {
      f = new Font("Dialog", Font.ITALIC, i);
      n.t1.setFont(f);
    }
    if (str.equals("Plain")) {
      f = new Font("Dialog", Font.PLAIN, i);
      n.t1.setFont(f);
    }
    if (str.equals(" Bold Italic")) {
      f = new Font("Dialog", Font.BOLD | Font.ITALIC, i);
      n.t1.setFont(f);
    }
    if (str2.equals("cyan")) {
      c1 = Color.cyan;
    }
    if (str2.equals("red")) {
      c1 = Color.red;
    }
    if (str2.equals("black")) {
      c1 = Color.black;
    }
    if (str2.equals("green")) {
      c1 = Color.green;
    }
    if (str2.equals("blue")) {
      c1 = Color.blue;
    }
    if (str2.equals("darkgray")) {
      c1 = Color.darkGray;
    }
    if (str2.equals("magenta")) {
      c1 = Color.magenta;
    }
    if (str2.equals("orange")) {
      c1 = Color.orange;
    }
    if (str2.equals("pink")) {
      c1 = Color.pink;
    }
    if (str2.equals("gray")) {
      c1 = Color.gray;
    }
    if (str2.equals("lightgray")) {
      c1 = Color.lightGray;
    }
    if (str2.equals("yellow")) {
      c1 = Color.yellow;
    }
    if (str2.equals("white")) {
      c1 = Color.white;
    }
    if (str3.equals("pink")) {
      c2 = Color.pink;
    }
    if (str3.equals("green")) {
      c2 = Color.green;
    }
    if (str3.equals("white")) {
      c2 = Color.white;
    }
    if (str3.equals("yellow")) {
      c2 = Color.yellow;
    }
    if (str3.equals("grey")) {
      c2 = Color.gray;
    }
    if (str3.equals("lightgrey")) {
      c2 = Color.lightGray;
    }
    if (str3.equals("red")) {
      c2 = Color.red;
    }
    if (str3.equals("orange")) {
      c2 = Color.orange;
    }
    if (str3.equals("magenta")) {
      c2 = Color.magenta;
    }
    if (str3.equals("darkgrey")) {
      c2 = Color.darkGray;
    }
    if (str3.equals("cyan")) {
      c2 = Color.cyan;
    }
    if (str3.equals("blue")) {
      c2 = Color.blue;
    }
    if (str3.equals("black")) {
      c2 = Color.black;
    }
    n.t1.setBackground(c1);
    n.t1.setForeground(c2);
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    if (str.equals("cancel")) {
      n.t1.setBackground(Color.white);
      n.t1.setForeground(Color.black);
      f = new Font("Dialog", Font.PLAIN, 36);
      n.t1.setFont(f);
      setVisible(false);
    }
    if (str.equals("ok")) {
      setVisible(false);
    }
  }
}

class kool1 extends WindowAdapter {
  samplefont g;

  kool1(samplefont g) {
    this.g = g;
  }

  public void windowClosing(WindowEvent we) {
    g.dispose();
  }
}

class helptopics extends Dialog implements ItemListener {
  menu n;
  Choice os;
  TextArea t1;
  String str;
  int i;

  public helptopics(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    os = new Choice();
    t1 = new TextArea();
    add(t1);
    os.add("new document for write");
    os.add("copy text");
    os.add("paste text");
    os.add("delete text");
    os.add("replace text");
    os.add("find text");
    add(os);
    os.addItemListener(this);
    addWindowListener(new joo1(this));
  }

  public void itemStateChanged(ItemEvent ie) {
    str = os.getSelectedItem();
    if (str.equals("new document for write")) {
      t1.setText("click on file option then on new menu item u get the new page for writing");
    }
    if ((str.equals("copy text")) || (str.equals("paste text")) || (str.equals("delete text"))
        || (str.equals("cut text"))) {
      String str1 = "..To cut text so you can move it to another location";
      String str2 = "select the text then on the EDIT menu click CUT";
      String str3 = "..To copy Text so you can paste it in another location,";
      String str4 = "select text,and then on EDIT menu click COPY.";
      String str5 = "..To paste text u have cut or copied , place the";
      String str6 = "  cursor where u want to paste and then on the EDIt menu click PASTE.";
      String str7 = "..To delete text,select it, then on EDIT menu click DELETE";
      t1.setText(str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5 + "\n" + str6 + "\n" + str7);
    }
  }

}

class joo1 extends WindowAdapter {
  helptopics g;

  joo1(helptopics g) {
    this.g = g;
  }

  public void windowClosing(WindowEvent we) {
    g.dispose();
  }
}

class goto1 extends Dialog implements ActionListener {
  int t;
  menu n;
  TextField t1;
  Button b1, b2;
  Label l1;
  String str, str1;

  public goto1(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    l1 = new Label("GO TO FOR");
    t1 = new TextField(15);
    b1 = new Button("ok");
    b2 = new Button("cancel");
    add(l1);
    add(t1);
    add(b1);
    add(b2);
    t = 0;
    b1.addActionListener(this);
    b2.addActionListener(this);
    addWindowListener(new goo1(this));
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    if (str.equals("ok")) {
      str1 = t1.getText();
      t = n.t1.getText().indexOf(str1);
      n.t1.select(t, t + str1.length());
    }
    if (str.equals("Cancel")) {
      setVisible(false);
    }

  }
}

class goo1 extends WindowAdapter {
  goto1 g;

  goo1(goto1 g) {
    this.g = g;
  }

  public void windowClosing(WindowEvent we) {
    g.dispose();
  }
}

class find1 extends Dialog implements ActionListener {
  int t;
  menu n;
  TextField t1;
  Button b2, b3;
  Label l1;
  String str, str1;

  public find1(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    l1 = new Label("Find What");
    t1 = new TextField(15);
    b2 = new Button("cancel");
    b3 = new Button("find next");
    add(l1);
    add(t1);
    add(b3);
    add(b2);
    t = 0;
    b2.addActionListener(this);
    b3.addActionListener(this);
    addWindowListener(new foo2(this));
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    if (str.equals("find next")) {
      str1 = t1.getText();
      t = n.t1.getText().indexOf(str1, t + str1.length());
      n.t1.select(t, t + str1.length());
    }
    if (str.equals("Cancel")) {
      setVisible(false);
    }

  }
}

class foo2 extends WindowAdapter {
  find1 f1;

  foo2(find1 f1) {
    this.f1 = f1;
  }

  public void windowClosing(WindowEvent we) {
    f1.dispose();
  }
}

class cut extends Dialog implements ActionListener {
  Button b1;
  Label l;
  menu n;
  String str;

  public cut(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    b1 = new Button("ok");
    l = new Label(" (?)    Text is not Selected");
    add(l);
    add(b1);
    b1.addActionListener(this);
    addWindowListener(new foo3(this));
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    if (str.equals("ok")) {
      setVisible(false);
    }
  }
}

class foo3 extends WindowAdapter {
  cut f1;

  foo3(cut f1) {
    this.f1 = f1;
  }

  public void windowClosing(WindowEvent we) {
    f1.dispose();
  }
}

class cut1 extends Dialog implements ActionListener {
  Button b1;
  Label l;
  menu n;
  String str;

  public cut1(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    b1 = new Button("ok");
    l = new Label(" (?)    Text is not Selected");
    add(l);
    add(b1);
    b1.addActionListener(this);
    addWindowListener(new foo5(this));
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    if (str.equals("ok")) {
      setVisible(false);
    }
  }
}

class foo5 extends WindowAdapter {
  cut1 f1;

  foo5(cut1 f1) {
    this.f1 = f1;
  }

  public void windowClosing(WindowEvent we) {
    f1.dispose();
  }
}

class anotepad extends Dialog implements ActionListener {
  Button b1;
  Label l, l1, l2;
  menu n;
  String str;

  public anotepad(menu n, String str) {
    super(n, str, false);
    this.n = n;
    setLayout(new FlowLayout());
    setForeground(Color.black);
    setBackground(Color.gray);
    b1 = new Button("ok");
    l = new Label("                          NOTEPAD_2007                                                          ");
    l1 = new Label("                         VERSION JDK1.3                                                        ");
    l2 = new Label("                         MADE BY SWATI GARG                                                    ");
    add(l);
    add(l1);
    add(l2);
    add(b1);
    b1.addActionListener(this);
    addWindowListener(new foo4(this));
  }

  public void actionPerformed(ActionEvent ae) {
    str = ae.getActionCommand();
    if (str.equals("ok")) {
      setVisible(false);
    }
  }
}

class foo4 extends WindowAdapter {
  anotepad f1;

  foo4(anotepad f1) {
    this.f1 = f1;
  }

  public void windowClosing(WindowEvent we) {
    f1.dispose();
  }
}

class notepad {
  public static void main(String args[]) {
    menu n = new menu();
    n.setVisible(true);
    n.setSize(500, 500);
  }
}
