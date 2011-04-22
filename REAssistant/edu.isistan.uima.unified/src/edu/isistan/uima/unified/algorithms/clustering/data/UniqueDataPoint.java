package edu.isistan.uima.unified.algorithms.clustering.data;

public class UniqueDataPoint extends DefaultDataPoint {
	private static int uniqueIdCount = 0;
	private int uniqueId;
	
	/**
	 * Construct a new UniqueDataPoint with an unique identificator and value.
	 * @param value The double value of this data point
	 */
	public UniqueDataPoint(double value) {
		super(value);
		this.uniqueId = uniqueIdCount++;
	}

	/**
	 * Getter for the uniqueId.
	 * @return The uniqueId
	 */
	public int getUniqueId() {
		return uniqueId;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getUniqueId() + ":" + getValue();
	}	
}