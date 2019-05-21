package swing.police.gui;

import swing.police.NessunaVolanteException;
import swing.police.VolantiManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AlarmHandler implements ActionListener{
	
	private VolantiManager vm;
	private PoliceMainFrame frame;
	
	public AlarmHandler(VolantiManager vm, PoliceMainFrame frame){
		this.vm = vm;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		PoliceMainFrame.MyButton button = (PoliceMainFrame.MyButton) event.getSource();
		try {
			String res = vm.notificaVolanti(button.getZona());
			frame.setText(res);
		} catch (NessunaVolanteException e) {
			JOptionPane.showMessageDialog(null, "Nessun volante nella zona segnalata!",
					"Attenzione!", JOptionPane.ERROR_MESSAGE);
		}

	}	

}
