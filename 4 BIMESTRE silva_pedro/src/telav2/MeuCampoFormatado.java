package telav2;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFormattedTextField;

public class MeuCampoFormatado extends JFormattedTextField implements FocusListener {

    private boolean obrigatorio;

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public MeuCampoFormatado() {
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBackground(Color.white);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (obrigatorio==true && getText().equals("")) {
            setBackground(Color.blue);
        }

    }
}

