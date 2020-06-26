package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import model.Appointment;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnectorProcedure implements Connector {

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		// TODO Auto-generated method stub
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();

		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/cases_procedures.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null)
			{
				if (line.startsWith("#") || (line.length() == 0))
					continue;

				CBRCase cbrCase = new CBRCase();

				Appointment app = new Appointment(line);

				cbrCase.setDescription(app);
				cases.add(cbrCase);
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cases;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub

	}

}
