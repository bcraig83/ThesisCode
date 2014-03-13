package ie.lyit.domain;

import java.util.Date;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

/*
 * DTO describing a project
 */
@CsvDataType()
public class ProjectDTO {

	@CsvField(pos = 1)
	private String name = null;

	@CsvField(pos = 2)
	private String status = null;

	@CsvField(pos = 3)
	private int systemVersionCount = 0;

	@CsvField(pos = 4)
	private String description = null;

	@CsvField(pos = 5)
	private String version = null;

	@CsvField(pos = 6)
	private String fullName = null;

	@CsvField(pos = 7)
	private String domain = null;

	@CsvField(pos = 8)
	private String jreVersion = null;

	@CsvField(pos = 9)
	private String license = null;

	@CsvField(pos = 10)
	private String distribution = null;

	@CsvField(pos = 11, format = "yyyy-MM-dd")
	private Date releaseDate = null;

	@CsvField(pos = 12)
	private String sourcePackages = null;

	@CsvField(pos = 13)
	private int nBin = 0;

	@CsvField(pos = 14)
	private int nBoth = 0;

	@CsvField(pos = 15)
	private int nFiles = 0;

	@CsvField(pos = 16)
	private int nTop = 0;

	@CsvField(pos = 17)
	private int loc = 0;

	@CsvField(pos = 18)
	private int ncloc = 0;

	@CsvField(pos = 19)
	private String url = null;

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public int getSystemVersionCount() {
		return systemVersionCount;
	}

	public String getDescription() {
		return description;
	}

	public String getVersion() {
		return version;
	}

	public String getFullName() {
		return fullName;
	}

	public String getDomain() {
		return domain;
	}

	public String getJreVersion() {
		return jreVersion;
	}

	public String getLicense() {
		return license;
	}

	public String getDistribution() {
		return distribution;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public String getSourcePackages() {
		return sourcePackages;
	}

	public int getnBin() {
		return nBin;
	}

	public int getnBoth() {
		return nBoth;
	}

	public int getnFiles() {
		return nFiles;
	}

	public int getnTop() {
		return nTop;
	}

	public int getLoc() {
		return loc;
	}

	public int getNcloc() {
		return ncloc;
	}

	public String getUrl() {
		return url;
	}

}
