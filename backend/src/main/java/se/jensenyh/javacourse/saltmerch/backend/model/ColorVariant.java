package se.jensenyh.javacourse.saltmerch.backend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ColorVariant
{
    // todo: needs fields: String colorName, List of String images, List of SizeContainer sizes
    
    // todo: all fields should be public and annotated with @JsonProperty

  @JsonProperty("colorName") public String colorName;
  @JsonProperty("images") public ArrayList<String> images;
  @JsonProperty("sizes") public List<SizeContainer> sizes;

    // todo: needs 2 constructors:
    //  1. empty constructor: this one needs to initialize images and sizes as new ArrayList<>()
    //  2. constructor with colorName, sizes, and images


  public ColorVariant()
  {
    this.sizes  = new ArrayList<SizeContainer>();
    this.images = new ArrayList<String>();
  }
  public ColorVariant(String colorName, ArrayList<SizeContainer> sizes, ArrayList<String> images)
  {
    this.colorName = colorName;
    this.sizes = sizes;
    this.images = images;
  }

  // NOTE: you can leave this method as it is; it's used in ProductRepository.java
    public void setImagesFromCSV(String csv) throws Exception
    {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }
}
