package com.danti.ojasaee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);



        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);



        List<ModelClass> modelClassList=new ArrayList<>();

        modelClassList.add(new ModelClass(R.drawable.lightplastic,"Light from plastic bottles","How a bottle of water is spreading lights in the dark slums of Manila. Project of installing bottle filled with water, as source of light."));
        modelClassList.add(new ModelClass(R.drawable.polypond,"Poly Pond","Poly Ponds making Farmers' life easy in MP- Due to lack of timely rains in many parts of India, the entire year's hard work of farmers is wasted. The situation in Mandsaur district of Madhya Pradesh is no different. But some farmers there have found a solution to this problem. After this, they no longer have the same dependence on rain and they are taking three crops from their fields in a year."));
        modelClassList.add(new ModelClass(R.drawable.ac,"Alternative of air conditioning "," Air conditioning systems are used all over the world during the summer season. On one hand, there is a heavy consumption of electricity, while on the other hand, they release a lot of heat into the environment. In such a situation, many people are looking for an alternative to AC. There has been such an attempt in India also. The great thing is that the potters have a big contribution to this."));
        modelClassList.add(new ModelClass(R.drawable.batik,"Sustainable dyeing"," Batik dyeing has been taking place in the western state of India, Gujarat for centuries. But now cheap synthetic colors are ending this tradition, which is also harming the environment. But some artisans are busy saving their traditions. Some designers are using organic colors."));
        modelClassList.add(new ModelClass(R.drawable.tshirt,"2,500 liters for a T-shirt"," Everything we use has an impact on the environment. Take the t-shirt for example. You may get the t-shirt very cheaply, but the environment has to pay a big price for it."));
        modelClassList.add(new ModelClass(R.drawable.pee,"Old buses into women's toilets"," Thirty-five crore girls and women in the world do not have toilet facilities. India is at the forefront of this list. I have heard women saying many times that they do not drink water throughout the day or eat less food so that they do not have to go to the toilet. It is shameful to deal with this kind of problem in the twenty-first century. In Pune, an organization has come up with excellent solutions to help women. The bus has lots of facilities like the availability of the sanitary pad, baby diaper, toilet seat sanitizer, and breastfeeding chair."));
        modelClassList.add(new ModelClass(R.drawable.sustainability,"Homes from shipping container","When there is a need to build houses quickly at a low cost, then today shipping containers are being used the most in the world for this. They have also been used to build hostels, hotels, restaurants and even small school in India."));
        modelClassList.add(new ModelClass(R.drawable.green," Meaning of green home","The rapid industrialization that has taken place in the last century and as a result, the cities have grown, has cut our houses from nature. The methods used to build buildings are constantly damaging nature. Architects from Delhi want to modify this and making homes ecofriendly."));
        modelClassList.add(new ModelClass(R.drawable.stupa,"Magic of Indian Engineer"," Stupa-sized water reserves are being used in Ladakh. Ice stupas are being built there. Due to the cone shape, these stupas melt slowly and provide water to the farmers. Sonam Wangchuk's brain is working behind this idea."));
        modelClassList.add(new ModelClass(R.drawable.cold,"Solar Cold Storage in India"," Many times in India the crop gets spoiled because no one was buying it or because there were no godowns to keep it properly. Due to this waste, many times the food items in the market get scarred and their prices go up. If the root of this problem is eliminated, then the whole problem will be over. Some people in Gujarat are doing this."));
        modelClassList.add(new ModelClass(R.drawable.tapwater,"Toilet to tap"," In many countries, people are struggling with fresh and clean water for drinking. In many big cities in India, people have to put a line in front of a water tank to meet their water needs. In such a situation, a Delhi company is converting sewage water into clean drinking water."));
        modelClassList.add(new ModelClass(R.drawable.plsticoil,"Plastic waste to fuel"," Nowadays, plastic waste is everywhere. It is not only difficult to recycle, but it is also expensive. Now in India people are converting this plastic waste into crude oil. It is a profitable deal for them. It is also benefiting those people who do not have any clean energy sources for cooking LPG or food."));
        modelClassList.add(new ModelClass(R.drawable.rose,"Rose farming in Greenhouse"," Dumping carbon dioxide i.e. CO2 in open space is also like spreading garbage. This CO2 can also be beneficial. Oil refineries emit massive amounts of CO2. CO2 is a greenhouse gas, so its best place can be a greenhouse where this gas can help in growing plants. CO2 is benefiting in growing roses."));
        modelClassList.add(new ModelClass(R.drawable.foodwaste,"Biogas from Food waste"," Food is one of our most important needs. But humans waste a lot of food. Apart from this, a lot of garbage is also produced in the process of cooking. A Mumbai organization has found a way to use this waste and biogas is being made from it. See how waste is being converted into fuel."));
        modelClassList.add(new ModelClass(R.drawable.airtowater,"Generate water from air"," The magicians turn their hands in the air and sometimes remove the coin and sometimes the flowers. Even so, but have you seen the water being removed from the air? See how such technology is being developed for areas affected by drought."));
        modelClassList.add(new ModelClass(R.drawable.plain,"Flying without motor"," Phoenix - A completely new type of aircraft. The researcher who made it says that it flies without a motor, propulsion technology can remain in the air for a very long time and it breathes. Due to the ability to breathe, this aircraft can not only move up and down in the air but due to this it also moves forward. Let us know how these cheap aircraft filled with light gas like helium are there and what can be done from them in the future. "));
        modelClassList.add(new ModelClass(R.drawable.privatejungle,"India's first private sanctuary"," Anil Kumar Malhotra and his wife Pamela Malhotra bought 55 acres of idle land in Karnataka in the 1990s. Then they started planting saplings on this land. Today their rich forest has spread over 1.2 sq km. This first private century of India is today home to many wild animals."));
        modelClassList.add(new ModelClass(R.drawable.phone,"Battery from apple skin"," Lithium is present in almost every battery used worldwide - from mobile phones to electric cars. When there is so much demand for only one thing, then obviously it will harm the environment. That is why scientists have started searching for its alternative. For example, why not use sodium or magnesium, which is found in plenty in our environment, in which more energy than lithium can be stored."));
        modelClassList.add(new ModelClass(R.drawable.huskplastic,"Packaging from Biowaste"," There is a lot of criticism of the packaging industry all over the world because of this, pollution due to plastic is increasing. Until a new and sustainable method comes into the market, it cannot be rescued. A Delhi-based company has come up with a packaging that is completely natural, biodegradable, and made from husk to deal with this problem. This model is proving helpful in moving towards the green economy."));
        modelClassList.add(new ModelClass(R.drawable.furniture,"Waste to Furniture"," People are Making beautiful furniture out of discarded items. The furniture you might not have even thought of. Old clothes, tires, or rope are all materials to create something new. "));
        modelClassList.add(new ModelClass(R.drawable.sabu,"Plastic Made of Manioc"," Indonesia is the second-largest producer of plastic waste in the world after China. To reduce the use of plastic, many types of options are being discovered. Especially, everyday things are being tried to be made with materials that do not harm the environment. Sago-made bags are also the result of this effort."));
        modelClassList.add(new ModelClass(R.drawable.airgenerator,"Reduce air pollution"," In the last hundred years, as a result of the change in our lifestyle, the air around us has increased toxic. We breathe in this air. Look at Delhi, as soon as electricity is cut, diesel generators start running here. 16 percent of Delhi's pollution is from the smoke originating from these generators. See how a startup is trying to reduce it by implementing a chakra shield."));
        modelClassList.add(new ModelClass(R.drawable.stove,"The stoves produce less carbon","The biggest problem with the wood-burning stove is the smoke emanating from it. This smoke is harmful, which has a big impact on the health and environment of the cook. But a new type of stove has come into the Indian market, which produces less smoke. They also diminish air pollution and adversely affect the health of the cook."));
        modelClassList.add(new ModelClass(R.drawable.bus,"The Zero-emission bus"," Due to the trains running on diesel and petrol, our climate is continuously deteriorating. For us to breathe good air, it is important that such fuel options are discovered which do not cause smoke. CNG has been in use in India for many years, so preparations are on to run a hydrogen bus in Belgium."));
        modelClassList.add(new ModelClass(R.drawable.cell,"Lenses for solar cells"," Not only Japan but the whole world learned many lessons from the 2011 Fukushima nuclear accident. Only then did Germany decide to shut all its nuclear plants by 2022, and Switzerland started its energy policy 2050, which aims to make the country completely nuclear energy free."));
        modelClassList.add(new ModelClass(R.drawable.garbage," Earning from Garbage in India"," When we see big garbage mountains in our city, then suddenly they are surprised. Fifteen thousand tons of garbage are released every day in India. Neither is it a solution to deposit it in the plains nor to burn it in the open. Some start-up companies are now looking for ways to deal with it by recycling it into useful things in India."));
        modelClassList.add(new ModelClass(R.drawable.houseelec,"Electric conductor House"," Solar panels can be very helpful in making buildings eco-friendly. But they are very expensive to install and these panels do not convert sunlight into electricity all the time. How would it be if the whole building started making electricity? A university in Germany is looking for ways to do this."));
        modelClassList.add(new ModelClass(R.drawable.red,"How can we reduce plastic"," The amount of plastic we throw every day cannot be reduced in any way? After all, every year eighty million tons of plastic waste is reaching our seas. Can anyone not become eco-friendly plastic? The answer is Red algae. we can use it instant of plastic in food packaging. It not only sustains the environment but also benefits local farmers."));
        modelClassList.add(new ModelClass(R.drawable.satelite,"Energy supply in satellites"," Have you ever thought that how they work by transferring pictures of the Earth from satellite space? This is possible due to radioisotope thermoelectric generators or RTGs."));
        modelClassList.add(new ModelClass(R.drawable.energygif,"Germany Energy Storage Plant"," Local coal mines are being closed in Germany. With this, the question is also being raised as to what to do with the empty mines. Empty mines are used for energy storage."));
        modelClassList.add(new ModelClass(R.drawable.grppic,"IISWBM EnCon 2019"," IISWBM has celebrated EnCon 2019 on 14 December"));

        Adapter adapter=new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Toast.makeText(getApplicationContext(), "This app is developed and maintained by Arpita Dey, Vice President, AEE Kolkata Student Chapter, IISWBM MBA-PS", Toast.LENGTH_LONG).show();


        if (id == R.id.action_item_two) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
