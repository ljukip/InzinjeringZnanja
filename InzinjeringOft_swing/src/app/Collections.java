package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

import model.Appointment;
import model.Patient;


public class Collections implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1463191671973434571L;
	private ArrayList<Patient> PatientList;
	private static Collections instance;

	public Collections()
	{
		PatientList = new ArrayList<Patient>();
	}
	
	public ArrayList<Patient> getPatientList()
	{
		return PatientList;
	}

	public void setPatientList(ArrayList<Patient> PatientList)
	{
		this.PatientList = PatientList;
	}

	public static Collections getInstance()
	{
		if (instance == null)
		{
			instance = new Collections();

		}
		return instance;
	}

	public boolean add(Patient p)
	{
		return PatientList.add(p);
	}

	public void addAppointment(Patient p, Appointment appointment)
	{

		for (Patient a : this.PatientList)
		{
			if (a.getJmbg() == p.getJmbg())
			{
				a.getAppointments().add(appointment);
			}
		}
	}

	public boolean addAll(Collection<? extends Patient> patients)
	{
		return PatientList.addAll(patients);
	}

	public void clear()
	{
		PatientList.clear();
	}

	public Object clone()
	{
		return PatientList.clone();
	}

	public boolean contains(Object p)
	{
		return PatientList.contains(p);
	}

	public boolean containsAll(Collection<?> patients)
	{
		return PatientList.containsAll(patients);
	}

	public void ensureCapacity(int x)
	{
		PatientList.ensureCapacity(x);
	}

	public boolean equals(Object p)
	{
		return PatientList.equals(p);
	}

	public void forEach(Consumer<? super Patient> o)
	{
		PatientList.forEach(o);
	}

	public Patient get(int i)
	{
		return PatientList.get(i);
	}

	public int hashCode()
	{
		return PatientList.hashCode();
	}

	public int indexOf(Object o)
	{
		return PatientList.indexOf(o);
	}

	public boolean isEmpty()
	{
		return PatientList.isEmpty();
	}

	public Iterator<Patient> iterator()
	{
		return PatientList.iterator();
	}

	public int lastIndexOf(Object o)
	{
		return PatientList.lastIndexOf(o);
	}

	public ListIterator<Patient> listIterator()
	{
		return PatientList.listIterator();
	}

	public ArrayList<Patient> remove(Patient p)
	{
		PatientList.remove(p);
		return PatientList;
	}

	public boolean removeAll()
	{
		return PatientList.removeAll(PatientList);
	}
	public String toString()
	{
		return "Chart";
	}

}

