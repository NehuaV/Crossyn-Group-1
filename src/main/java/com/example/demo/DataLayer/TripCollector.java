package com.example.demo.DataLayer;

//A class that takes the dataset name as a parameter and processes it
public class TripCollector {
    //creating paths for the files
    /*String pathString = null;
    String jsonPath =null;
    //JsonTrip stores all the data from 1 trip
    List<JsonTrip> jtList = new ArrayList<>();
    JsonTrip jt;
    SetReader sr;
    TripSplitter ts;
    int averageSpeed;
    public TripCollector(String dataset) throws FileNotFoundException {
        GetPath();
        this.sr = new SetReader(pathString + dataset);
        this.ts = new TripSplitter(sr.GetTextList()); //Reads all the text in the dataset
        ts.Splitter(); //Splits the dataset into trips
        for(Trip trip : ts.GetManager().ReturnTrips()) //Writes each splitted trip into a .txt file
        {
            try
            {
                ts.GetManager().TripWriter();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        for(Trip trip : ts.GetManager().ReturnTrips())
        {
            jt = new JsonTrip();
            try {
                jt.deserializeTripObject(jsonPath + trip.getTripname() + ".txt"); //Converts txt file into TripObject
                jtList.add(jt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (JsonTrip jt : jtList)
        {
            jt.calculateAvgSpeed();
            jt.calculateDistance();
        }
    }
    /*public List<JsonConvertor> ReturnTrip()
    {
        return jc.getTrips();
    }

    private void SetDistance()
    {

    }
    //set the paths for the trip files
    public void GetPath() throws FileNotFoundException {
        //variable for selecting dataset
        String datasetName = "";
        //creating a path object
        Path p1 = Paths.get("dummy\\");
        //adding the folders to the datasets and adding required dataset
        pathString = p1.toUri().getRawPath();
        String[] parts = pathString.split("dummy");
        jsonPath = null;
        if (parts.length > 0) {
            pathString = parts[0];
            //System.out.println(pathString);
            //replace %20 from paths if folder name has a space
            parts = pathString.split("%20");
            for (int i = 0; i < parts.length; i++) {
                if (i == 0) {
                    pathString = parts[0];
                } else {
                    pathString = pathString + " " + parts[i];
                }
            }
        }
        jsonPath = pathString + "datasets/trips/";
        pathString = pathString + "datasets/raw data/";

    }

    public List<JsonTrip> getAllTrips() {
        return jtList;
    }
    public JsonTrip getTrip(int index)
    {
        return jtList.get(index);
    }

     */
}
