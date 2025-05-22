 7.	public class Farmer {
8.	    private String name;
9.	    private String phoneNumber;
10.	    private String Address;
11.	    private String[] crops;
12.	    private double Acres;
13.	    private int regno;
14.	    
15.	    
16.	    public Farmer(String name, String phoneNumber, String location, String[] crops, double acres,int regno) {
17.	        this.name = name;
18.	        this.phoneNumber = phoneNumber;
19.	        this.Address = location;
20.	        this.Acres=acres;
21.	        this.crops = crops;
22.	        this.regno= regno;
23.	
24.	    }
25.	
26.	    
27.	    public String getName() {
28.	        return name;
29.	    }
30.	
31.	    public String getPhoneNumber() {
32.	        return phoneNumber;
33.	    }
34.	
35.	    public String getAddress() {
36.	        return Address;
37.	    }
38.	
39.	    public String[] getCrops() {
40.	        return crops;
41.	    }
42.	    public double getAcres() {
43.	        return Acres;
44.	    }
45.	    public int getRegno() {
46.	        return regno;
47.	    }
48.	
49.	    
50.	    
51.	
52.	    public String toString() {
53.	        StringBuilder cropsList = new StringBuilder();
54.	        for (String crop : crops) {
55.	            if (crop != null && !crop.isEmpty()) { 
56.	                if (cropsList.length() > 0) {
57.	                    cropsList.append(", ");
58.	                }
59.	                cropsList.append(crop);
60.	            }
61.	        }
62.	    
63.	        return "Farmer Details \n" +
64.	                "Registration Number: "+ regno+
65.	               "\n Name: " + name + "\n" +
66.	               "Phone: " + phoneNumber + "\n" +
67.	               "Address: " + Address + "\n" +
68.	               "Crops: " + cropsList + "\n" +
69.	               "Acres of land: " + Acres;
70.	    }
71.	    
72.	}


73.	import java.util.Arrays;
74.	import javafx.application.Application;
75.	import javafx.geometry.Insets;
76.	import javafx.scene.Scene;
77.	import javafx.scene.control.*;
78.	import javafx.scene.layout.GridPane;
79.	import javafx.scene.layout.VBox;
80.	import javafx.scene.paint.Color;
81.	import javafx.scene.text.Font;
82.	import javafx.stage.Stage;
83.	import javafx.scene.text.Text;
84.	
85.	public class FarmerRegistrationSystem extends Application {
86.	    private Farmer[] farmers = new Farmer[2000];
87.	    private int totalCount = 0;
88.	    public FarmerRegistrationSystem(Farmer[] farmers) {
89.	        this.farmers = farmers;
90.	    }
91.	    public void start(Stage primaryStage) {
92.	        primaryStage.setTitle("Farmer Registration System");
93.	
94.	       
95.	        TextField nameField = new TextField();
96.	        nameField.setPromptText("name");
97.	        TextField phoneField = new TextField();
98.	        phoneField.setPromptText("+91 XXXXXXXXXX");
99.	        TextField addressField = new TextField();
100.	        addressField.setPromptText("address");
101.	        TextField acresField = new TextField();
102.	        acresField.setPromptText("acres in decimal");
103.	        CheckBox crop1 = new CheckBox("Wheat");
104.	        CheckBox crop2 = new CheckBox("Rice");
105.	        CheckBox crop3 = new CheckBox("Corn");
106.	        CheckBox crop4 = new CheckBox("Soybeans");
107.	        CheckBox crop5 = new CheckBox("Cotton");
108.	
109.	        
110.	        
111.	        ListView<String> farmerListView = new ListView<>();
112.	        Text registrationNumberText = new Text();
113.	        registrationNumberText.setFont(new Font(18));
114.	        registrationNumberText.setFill(Color.RED);
115.	
116.	        // Register button
117.	        Button registerButton = new Button("Register Farmer");
118.	        registerButton.setOnAction(e -> {
119.	            String name = nameField.getText();
120.	            String phoneNumber = phoneField.getText();
121.	            String address = addressField.getText();
122.	            double acres;
123.	            
124.	
125.	            try {
126.	                acres = Double.parseDouble(acresField.getText());
127.	            } catch (NumberFormatException ex) {
128.	                System.out.println("Invalid Acres- Please enter a valid number");
129.	                return;
130.	            }
131.	
132.	            
133.	            if (totalCount >= farmers.length) {
134.	                System.out.println("Registration Full- No more farmers can be registered.");
135.	                return;
136.	            }
137.	            String[] selectedCrops = getSelectedCrops(crop1, crop2, crop3, crop4, crop5);
138.	            int registrationNumber = 1000 + totalCount;
139.	            registrationNumberText.setText("Your REGISTRATION NUMBER IS: " + registrationNumber);
140.	            Farmer farmer = new Farmer(name, phoneNumber, address, selectedCrops, acres,registrationNumber);
141.	            farmers[totalCount] = farmer;
142.	            totalCount++;
143.	            System.out.println(farmers.length);
144.	           
145.	
146.	            
147.	           
148.	            farmerListView.getItems().add(farmer.toString());
149.	            clearFormFields(nameField, phoneField, addressField,  acresField);
150.	            
151.	            crop1.setSelected(false);
152.	            crop2.setSelected(false);
153.	            crop3.setSelected(false);
154.	            crop4.setSelected(false);
155.	            crop5.setSelected(false);
156.	        });
157.	
158.	           GridPane formGrid = new GridPane();
159.	        formGrid.setPadding(new Insets(10));
160.	        formGrid.setVgap(10);
161.	        formGrid.setHgap(10);
162.	
163.	        formGrid.add(new Label("Name:"), 0, 0);
164.	        formGrid.add(nameField, 1, 0);
165.	        formGrid.add(new Label("Phone Number:"), 0, 1);
166.	        formGrid.add(phoneField, 1, 1);
167.	        formGrid.add(new Label("Address:"), 0, 2);
168.	        formGrid.add(addressField, 1, 2);
169.	        formGrid.add(new Label("Acres:"), 0, 3);
170.	        formGrid.add(acresField, 1, 3);
171.	        formGrid.add(new Label("Crops:"), 0, 4);
172.	        formGrid.add(crop1, 1, 4);
173.	        formGrid.add(crop2, 1, 5);
174.	        formGrid.add(crop3, 1, 6);
175.	        formGrid.add(crop4, 1, 7);
176.	        formGrid.add(crop5, 1, 8);
177.	        formGrid.add(registerButton, 1, 9);
178.	
179.	        VBox mainLayout = new VBox(10, formGrid,registrationNumberText, new Label("Registered Farmers:"), farmerListView);
180.	        mainLayout.setPadding(new Insets(10));
181.	
182.	        Scene scene = new Scene(mainLayout, 500, 500);
183.	        primaryStage.setScene(scene);
184.	        primaryStage.show();
185.	    }
186.	
187.	    private String[] getSelectedCrops(CheckBox... checkBoxes) {
188.	            return Arrays.stream(checkBoxes)
189.	                    .filter(CheckBox::isSelected)
190.	                    .map(CheckBox::getText)
191.	                    .toArray(String[]::new);
192.	    }
193.	    private void clearFormFields(TextField... fields) {
194.	        for (TextField field : fields) {
195.	            field.clear();
196.	        }
197.	    }
198.	
199.	    public static void main(String[] args) {
200.	        launch(args);
201.	    }
202.	}
203.	
204.	


Subsidy and Resource Management: Shows the use of inheritance and overriding using Subsidy as main class and its types as subclasses.
205.	public class Subsidy {
206.	    protected String subsidyName;
207.	
208.	    public Subsidy(String subsidyName) {
209.	        this.subsidyName = subsidyName;
210.	    }
211.	
212.	    
213.	    public double subsidyCalculation() {
214.	        System.out.println("Subsidy calculation depends on area of land and crops cultivated.");
215.	        return 0;
216.	    }
217.	
218.	    public String getSubsidyName() {
219.	        return subsidyName;
220.	    }
221.	
222.	    public void setSubsidyName(String subsidyName) {
223.	        this.subsidyName = subsidyName;
224.	    }
225.	}
226.	
227.	// Subclass 
228.	class InsuranceSubsidy extends Subsidy {
229.	    private double insuredAmount;
230.	    private double premiumRate= 8.0;
231.	
232.	    public InsuranceSubsidy(String subsidyName, double acres) {
233.	        super(subsidyName);
234.	        this.insuredAmount = acres*4000;
235.	        
236.	    }
237.	    public String infoSubsidy() {
238.	        return "\n Crop insurance is a type of insurance policy that protects farmers against financial losses due to adverse weather conditions, natural disasters, or other unforeseen events. These policies typically cover a portion of the farmer's expected revenue, helping to mitigate risks and stabilize income";
239.	    }
240.	    
241.	    public double subsidyCalculation() {
242.	        double subsidyAmount = insuredAmount * (premiumRate / 100);
243.	        System.out.println("Insurance Subsidy calculated: " + subsidyAmount);
244.	        return subsidyAmount;
245.	    }
246.	
247.	}
248.	
249.	// Subclass
250.	class CropSubsidy extends Subsidy {
251.	    private double cropYield;
252.	    private double subsidyRatePerUnit;
253.	
254.	    public CropSubsidy(String subsidyName, double cropYield, double acres) {
255.	        super(subsidyName);
256.	        this.cropYield = cropYield;
257.	        this.subsidyRatePerUnit = acres*15;
258.	    }
259.	
260.	  
261.	    public double subsidyCalculation() {
262.	        double subsidyAmount = cropYield * subsidyRatePerUnit;
263.	        System.out.println("Crop Subsidy calculated: " + subsidyAmount);
264.	        return subsidyAmount;
265.	    }
266.	    public String infoSubsidy() {
267.	        return "Crop-wise subsidies are government programs that provide financial support to farmers based on the specific crops they cultivate. These subsidies can vary in amount and eligibility depending on the crop, region, and government policies. Common crops that may receive subsidies include food grains like rice and wheat, oilseeds like soybean and groundnut, pulses, cash crops like cotton and sugarcane, and horticultural crops like fruits and vegetables. By providing targeted support, these subsidies aim to boost agricultural production, ensure food security, and improve rural livelihoods. However, it's crucial to implement these programs effectively and monitor their impact to avoid unintended consequences and ensure sustainability.";
268.	    }
269.	
270.	}
271.	import javafx.application.Application;
272.	import javafx.geometry.Insets;
273.	import javafx.scene.Scene;
274.	import javafx.scene.control.*;
275.	import javafx.scene.layout.GridPane;
276.	import javafx.scene.layout.VBox;
277.	import javafx.stage.Stage;
278.	

279.	public class ResourceManagement extends Application {
280.	    private Farmer[] farmers;
281.	
282.	    public ResourceManagement(Farmer[] farmers) {
283.	        
284.	        if (farmers == null) {
285.	            throw new IllegalArgumentException("Farmers array must be initialized and non-null");
286.	        }
287.	        this.farmers = farmers;
288.	    }
289.	
290.	    @SuppressWarnings("unused")
291.	    public void start(Stage primaryStage) {
292.	        primaryStage.setTitle("Search Farmer by Registration Number");
293.	
294.	        TextField searchField = new TextField();
295.	        Button searchButton = new Button("Search Farmer");
296.	        TextArea searchResultArea = new TextArea();
297.	        searchResultArea.setEditable(false);
298.	        searchResultArea.setWrapText(true);
299.	        ComboBox<String> subsidyTypeComboBox = new ComboBox<>();
300.	        subsidyTypeComboBox.getItems().addAll("Insurance Subsidy", "Crop Subsidy");
301.	        subsidyTypeComboBox.setVisible(false);
302.	        Button calculateSubsidyButton = new Button("Calculate Subsidy");
303.	        calculateSubsidyButton.setVisible(false);
304.	
305.	        TextField cropYField = new TextField();
306.	        cropYField.setPromptText("Enter type of crop");
307.	        cropYField.setVisible(false);
308.	
309.	        subsidyTypeComboBox.setOnAction(event -> {
310.	            if ("Crop Subsidy".equals(subsidyTypeComboBox.getValue())) {
311.	                cropYField.setVisible(true);
312.	            } else {
313.	                cropYField.setVisible(false);
314.	            }
315.	        });
316.	
317.	        searchButton.setOnAction(e -> {
318.	            try {
319.	                int regNo = Integer.parseInt(searchField.getText().trim());
320.	                Farmer farmer = findFarmerByRegistration(regNo);
321.	                
322.	                if (farmer != null) {
323.	                    searchResultArea.setText("Farmer Found:\n" + farmer.toString());
324.	                    subsidyTypeComboBox.setVisible(true);
325.	                    calculateSubsidyButton.setVisible(true);
326.	                    calculateSubsidyButton.setOnAction(ev -> {
327.	                        String selectedSubsidy = subsidyTypeComboBox.getValue();
328.	                       
329.	                        if (selectedSubsidy != null) {
330.	                            if (selectedSubsidy.equals("Insurance Subsidy")) {
331.	                                InsuranceSubsidy insuranceSubsidy = new InsuranceSubsidy("Farmer Insurance", farmer.getAcres());
332.	                                double amount = insuranceSubsidy.subsidyCalculation();
333.	                                searchResultArea.clear();
334.	                                searchResultArea.appendText("\nInsurance Subsidy Amount: " + amount);
335.	                                searchResultArea.appendText("\n" + insuranceSubsidy.infoSubsidy());
336.	                            } else if (selectedSubsidy.equals("Crop Subsidy")) {
337.	                               
338.	                                try {
339.	                                    double corpSelect = Double.parseDouble(cropYField.getText().trim());
340.	                                    CropSubsidy cropSubsidy = new CropSubsidy("Crop Regulation Subsidy", corpSelect, farmer.getAcres());
341.	                                    double amount = cropSubsidy.subsidyCalculation();
342.	                                    searchResultArea.clear();
343.	                                    searchResultArea.appendText("\nCrop Subsidy Amount: " + amount);
344.	                                    searchResultArea.appendText("\n" + cropSubsidy.infoSubsidy());
345.	                                } catch (NumberFormatException ex) {
346.	                                    
347.	                                    System.out.println("Please enter a valid numeric value.");
348.	                                    searchResultArea.appendText("\nPlease enter a valid numeric value.");
349.	                                }
350.	                                
351.	                               
352.	                            }
353.	                        } else {
354.	                            searchResultArea.appendText("\nPlease select a subsidy type.");
355.	                        }  });
356.	                } else {
357.	                    searchResultArea.setText("No farmer found with registration number: " + regNo);
358.	                }
359.	            } catch (NumberFormatException ex) {
360.	                searchResultArea.setText("Please enter a valid registration number.");
361.	            }
362.	        });
363.	       
364.	      
365.	
366.	        GridPane searchGrid = new GridPane();
367.	        searchGrid.setPadding(new Insets(10));
368.	        searchGrid.setVgap(10);
369.	        searchGrid.setHgap(10);
370.	
371.	        searchGrid.add(new Label("Enter Registration Number:"), 0, 0);
372.	        searchGrid.add(searchField, 1, 0);
373.	        searchGrid.add(searchButton, 2, 0);
374.	        searchGrid.add(searchResultArea, 0, 1, 3, 1);
375.	        searchGrid.add(new Label("Select Subsidy Type:"), 0, 2);
376.	        searchGrid.add(subsidyTypeComboBox, 1, 2);
377.	        searchGrid.add(cropYField, 1, 3); // Add the crop type input field
378.	        searchGrid.add(calculateSubsidyButton, 2, 3);
379.	
380.	        VBox mainLayout = new VBox(10, searchGrid);
381.	        mainLayout.setPadding(new Insets(10));
382.	
383.	        Scene scene = new Scene(mainLayout, 500, 300);
384.	        primaryStage.setScene(scene);
385.	        primaryStage.show();
386.	    }
387.	
388.	    private Farmer findFarmerByRegistration(int registrationNumber) {
389.	        for (Farmer farmer : farmers) {
390.	            if (farmer != null) {
391.	                if (farmer.getRegno() == registrationNumber) {
392.	                    return farmer;
393.	                }
394.	            }
395.	        }
396.	        return null;
397.	    }
398.	    
399.	}
400.	

Real-Time Data: Shows the use of Generic classes to display the data, the Generic class in T is locked in by two classes Weather and Cost.
401.	import javafx.application.Application;
402.	import javafx.scene.Scene;
403.	import javafx.scene.control.Label;
404.	import javafx.scene.layout.VBox;
405.	import javafx.stage.Stage;
406.	
407.	class RealData<T> {
408.	    private T data;
409.	
410.	    public RealData(T data) {
411.	        this.data = data;
412.	    }
413.	
414.	    public String getData() {
415.	        return data.toString();
416.	    }
417.	}
418.	
419.	class Weather {
420.	    private String forecast;
421.	
422.	    public Weather(String forecast) {
423.	        this.forecast = forecast;
424.	    }
425.	
426.	    @Override
427.	    public String toString() {
428.	        return "Weather Forecast:\n" + forecast;
429.	    }
430.	}
431.	
432.	class Cost {
433.	    private String crop;
434.	    private double price;
435.	
436.	    public Cost(String crop, double price) {
437.	        this.crop = crop;
438.	        this.price = price;
439.	    }
440.	    public String toString() {
441.	        return crop + ": " + price + " INR/KG";
442.	    }
443.	}
444.	
445.	public class RealDataApp extends Application {
446.	    public void start(Stage primaryStage) {
447.	        Weather weather = new Weather("In Manipal, Karnataka, the weather ahead is predicted to be mainly warm with occasional rainfall in the upcoming week.\n" +
448.	                "Temperatures will vary between 24°C at night and around 30°C during the day from Friday to Sunday, with the possibility of scattered showers and sporadic thunderstorms.\n" +
449.	                "From Monday to Tuesday, expect warm temperatures around 30°C with occasional rain showers and possible periods of cloudy weather.\n" +
450.	                "Rain and Moisture: The humidity will be elevated, creating a sensation of warmth, with a possibility of moderate rainfall on certain days such as Saturday, potentially accumulating up to 6.9 mm.");
451.	        RealData<Weather> weatherData = new RealData<>(weather);
452.	
453.	        Cost wheatCost = new Cost("Wheat", 35.6);
454.	        RealData<Cost> wheatData = new RealData<>(wheatCost);
455.	
456.	        Cost riceCost = new Cost("Rice", 29);
457.	        RealData<Cost> riceData = new RealData<>(riceCost);
458.	
459.	        Cost maizeCost = new Cost("Maize", 25);
460.	        RealData<Cost> maizeData = new RealData<>(maizeCost);
461.	
462.	        Label weatherLabel = new Label(weatherData.getData());
463.	        Label wheatLabel = new Label(wheatData.getData());
464.	        Label riceLabel = new Label(riceData.getData());
465.	        Label maizeLabel = new Label(maizeData.getData());
466.	
467.	        VBox root = new VBox(10, weatherLabel, wheatLabel, riceLabel, maizeLabel);
468.	        root.setStyle("-fx-padding: 20; -fx-font-size: 14px;");
469.	
470.	        Scene scene = new Scene(root, 600, 400);
471.	        primaryStage.setTitle("Weather and Crop Cost Information");
472.	        primaryStage.setScene(scene);
473.	        primaryStage.show();
474.	    }
475.	
476.	    public static void main(String[] args) {
477.	        launch(args);
478.	    }
479.	}
480.	

Communication and Support: shows implementation of javafx combobox and its functionalities.
481.	import javafx.application.Application;
482.	import javafx.geometry.Insets;
483.	import javafx.scene.Scene;
484.	import javafx.scene.control.*;
485.	import javafx.scene.layout.VBox;
486.	import javafx.stage.Stage;
487.	
488.	public class CombinedSolutionApp extends Application {
489.	
490.	    public void start(Stage primaryStage) {
491.	        primaryStage.setTitle("Solutions for Pest, Irrigation, and Policy Issues");
492.	        ComboBox<String> categoryComboBox = new ComboBox<>();
493.	        categoryComboBox.getItems().addAll("Pest Issues", "Irrigation Issues", "Policy Implementation Issues");
494.	        categoryComboBox.setPromptText("Select a category");
495.	
496.	       
497.	        ComboBox<String> issueComboBox = new ComboBox<>();
498.	        issueComboBox.setPromptText("Select an issue");
499.	        
500.	       
501.	        categoryComboBox.setOnAction(event -> {
502.	            issueComboBox.getItems().clear();
503.	            String selectedCategory = categoryComboBox.getValue();
504.	            if ("Pest Issues".equals(selectedCategory)) {
505.	                issueComboBox.getItems().addAll("aphids", "caterpillars", "spider mites", "whiteflies");
506.	            } else if ("Irrigation Issues".equals(selectedCategory)) {
507.	                issueComboBox.getItems().addAll("overwatering", "underwatering", "uneven watering", "waterlogging");
508.	            } else if ("Policy Implementation Issues".equals(selectedCategory)) {
509.	                issueComboBox.getItems().addAll("lack of stakeholder engagement", "insufficient resources", "poor communication", "resistance to change");
510.	            }
511.	        });
512.	
513.	        
514.	        Button identifyButton = new Button("Identify Issue");
515.	
516.	        TextArea solutionArea = new TextArea();
517.	        solutionArea.setEditable(false);
518.	        solutionArea.setWrapText(true);
519.	
520.	        identifyButton.setOnAction(event -> {
521.	            String selectedCategory = categoryComboBox.getValue();
522.	            String selectedIssue = issueComboBox.getValue();
523.	            StringBuilder solution = new StringBuilder();
524.	
525.	            if (selectedCategory == null) {
526.	                solution.append("Please select a category.");
527.	            } else if (selectedIssue == null) {
528.	                solution.append("Please select an issue.");
529.	            } else {
530.	                switch (selectedCategory) {
531.	                    case "Pest Issues":
532.	                        switch (selectedIssue) {
533.	                            case "aphids":
534.	                                solution.append("Solution for Aphids:\n- Use insecticidal soap.\n- Introduce ladybugs.\n\n");
535.	                                break;
536.	                            case "caterpillars":
537.	                                solution.append("Solution for Caterpillars:\n- Handpick them.\n- Use Bacillus thuringiensis (Bt).\n\n");
538.	                                break;
539.	                            case "spider mites":
540.	                                solution.append("Solution for Spider Mites:\n- Increase humidity.\n- Use neem oil.\n\n");
541.	                                break;
542.	                            case "whiteflies":
543.	                                solution.append("Solution for Whiteflies:\n- Use sticky traps.\n- Introduce natural predators.\n\n");
544.	                                break;
545.	                        }
546.	                        break;
547.	
548.	                    case "Irrigation Issues":
549.	                        switch (selectedIssue) {
550.	                            case "overwatering":
551.	                                solution.append("Solution for Overwatering:\n- Reduce watering frequency.\n- Improve drainage.\n\n");
552.	                                break;
553.	                            case "underwatering":
554.	                                solution.append("Solution for Underwatering:\n- Increase watering frequency.\n- Check soil moisture.\n\n");
555.	                                break;
556.	                            case "uneven watering":
557.	                                solution.append("Solution for Uneven Watering:\n- Adjust sprinkler heads.\n- Use soaker hoses.\n\n");
558.	                                break;
559.	                            case "waterlogging":
560.	                                solution.append("Solution for Waterlogging:\n- Create raised beds.\n- Improve soil aeration.\n\n");
561.	                                break;
562.	                        }
563.	                        break;
564.	
565.	                    case "Policy Implementation Issues":
566.	                        switch (selectedIssue) {
567.	                            case "lack of stakeholder engagement":
568.	                                solution.append("Solution for Lack of Stakeholder Engagement:\n- Conduct regular stakeholder meetings.\n- Create feedback mechanisms.\n\n");
569.	                                break;
570.	                            case "insufficient resources":
571.	                                solution.append("Solution for Insufficient Resources:\n- Allocate budget effectively.\n- Seek partnerships and grants.\n\n");
572.	                                break;
573.	                            case "poor communication":
574.	                                solution.append("Solution for Poor Communication:\n- Develop a clear communication strategy.\n- Utilize multiple communication channels.\n\n");
575.	                                break;
576.	                            case "resistance to change":
577.	                                solution.append("Solution for Resistance to Change:\n- Provide training and education.\n- Involve stakeholders in the change process.\n\n");
578.	                                break;
579.	                        }
580.	                        break;
581.	                }
582.	            }
583.	
584.	            solutionArea.setText(solution.toString());
585.	        });
586.	
587.	  
588.	        VBox vbox = new VBox(10);
589.	        vbox.getChildren().addAll(categoryComboBox, issueComboBox, identifyButton, solutionArea);
590.	        vbox.setPadding(new Insets(10));
591.	
592.	    
593.	        Scene scene = new Scene(vbox, 400, 300);
594.	        primaryStage.setScene(scene);
595.	        primaryStage.show();
596.	    }
597.	
598.	    public static void main(String[] args) {
599.	        launch(args);
600.	    }
601.	}

Monitoring and Reporting: used to monitor the crop type and its production using user input in the javafx implementation.
602.	import javafx.application.Application;
603.	import javafx.geometry.Insets;
604.	import javafx.scene.Scene;
605.	import javafx.scene.control.*;
606.	import javafx.scene.layout.GridPane;
607.	import javafx.scene.layout.VBox;
608.	import javafx.stage.Stage;
609.	
610.	import java.util.ArrayList;
611.	import java.util.List;
612.	
613.	public class CropMonitoringApp extends Application {
614.	
615.	    private List<Crop> crops = new ArrayList<>();
616.	    private TextArea reportArea;
617.	
618.	    public static void main(String[] args) {
619.	        launch(args);
620.	    }
621.	
622.	    @Override
623.	    public void start(Stage primaryStage) {
624.	        primaryStage.setTitle("Crop Monitoring and Reporting");
625.	
626.	        // Input fields
627.	        TextField cropNameInput = new TextField();
628.	        cropNameInput.setPromptText("Crop Name");
629.	
630.	        TextField productionInput = new TextField();
631.	        productionInput.setPromptText("Production Quantity (tons)");
632.	
633.	        TextField resourceInput = new TextField();
634.	        resourceInput.setPromptText("Resources Used (e.g., fertilizer, water)");
635.	
636.	        Button addButton = new Button("Add Crop Data");
637.	        addButton.setOnAction(e -> {
638.	            String cropName = cropNameInput.getText();
639.	            String production = productionInput.getText();
640.	            String resource = resourceInput.getText();
641.	
642.	            if (!cropName.isEmpty() && !production.isEmpty() && !resource.isEmpty()) {
643.	                crops.add(new Crop(cropName, production, resource));
644.	                cropNameInput.clear();
645.	                productionInput.clear();
646.	                resourceInput.clear();
647.	                updateReport();
648.	            } else {
649.	                showAlert("Input Error", "Please fill all fields before adding.");
650.	            }
651.	        });
652.	
653.	        reportArea = new TextArea();
654.	        reportArea.setEditable(false);
655.	        reportArea.setPrefHeight(200);
656.	
657.	        // Layout setup
658.	        GridPane inputGrid = new GridPane();
659.	        inputGrid.setPadding(new Insets(10));
660.	        inputGrid.setHgap(10);
661.	        inputGrid.setVgap(10);
662.	        inputGrid.add(new Label("Crop Name:"), 0, 0);
663.	        inputGrid.add(cropNameInput, 1, 0);
664.	        inputGrid.add(new Label("Production Quantity:"), 0, 1);
665.	        inputGrid.add(productionInput, 1, 1);
666.	        inputGrid.add(new Label("Resources Used:"), 0, 2);
667.	        inputGrid.add(resourceInput, 1, 2);
668.	        inputGrid.add(addButton, 1, 3);
669.	
670.	        VBox layout = new VBox(10, inputGrid, new Label("Generated Report:"), reportArea);
671.	        layout.setPadding(new Insets(15));
672.	
673.	        Scene scene = new Scene(layout, 400, 400);
674.	        primaryStage.setScene(scene);
675.	        primaryStage.show();
676.	    }
677.	
678.	    private void updateReport() {
679.	        StringBuilder report = new StringBuilder("Crop Monitoring Report\n\n");
680.	        for (Crop crop : crops) {
681.	            report.append("Crop Name: ").append(crop.getName()).append("\n")
682.	                    .append("Production: ").append(crop.getProduction()).append("\n")
683.	                    .append("Resources Used: ").append(crop.getResource()).append("\n\n");
684.	        }
685.	        reportArea.setText(report.toString());
686.	    }
687.	
688.	    private void showAlert(String title, String message) {
689.	        Alert alert = new Alert(Alert.AlertType.ERROR);
690.	        alert.setTitle(title);
691.	        alert.setContentText(message);
692.	        alert.showAndWait();
693.	    }
694.	
695.	    // Crop class to store crop data
696.	    static class Crop {
697.	        private final String name;
698.	        private final String production;
699.	        private final String resource;
700.	
701.	        public Crop(String name, String production, String resource) {
702.	            this.name = name;
703.	            this.production = production;
704.	            this.resource = resource;
705.	        }
706.	
707.	        public String getName() {
708.	            return name;
709.	        }
710.	
711.	        public String getProduction() {
712.	            return production;
713.	        }
714.	
715.	        public String getResource() {
716.	            return resource;
717.	        }
718.	    }
719.	}
