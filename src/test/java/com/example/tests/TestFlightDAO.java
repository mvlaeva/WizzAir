package com.example.tests;

import java.sql.SQLException;

import org.junit.Test;

import com.example.model.DBDAOs.FlightDAO;

public class TestFlightDAO {

	@Test
	public void test() throws SQLException {

		// new FlightDAO().showFlights("Sofia", "Bourgas", LocalDate.of(2016,
		// 10, 25));
		//

		new FlightDAO().insertCorrespondingAirports("Aberdeen", "Gdansk GDN Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Alesund", "Gdansk GDN Kaunas KUN Vilnius VNO");
		new FlightDAO().insertCorrespondingAirports("Alghero (Sardinia)",
				"Bucharest OTP Budapest BUD Katowice KTW Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Alicante",
				"Bucharest OTP Budapest BUD Cluj-Napoca CLJ Sofia SOF Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Baku", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Barcelona El Prat",
				"Bucharest OTP Budapest BUD Chisinau KIV Cluj-Napoca CLJ Craiova CRA Gdansk GDN Katowice KTW Kaunas KUN Poznan POZ Riga RIX Skopje SKP Sofia SOF Timisoara TSR Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Bari",
				"Bucharest OTP Budapest BUD Cluj-Napoca CLJ Katowice KTW Kaunas KUN Prague PRG Sofia SOF Timisoara TSR Vilnius VNO Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Basel-Mulhouse-Freiburg",
				"Belgrade BEG Nis INI Ohrid OHD Skopje SKP Tuzla TZL");
		new FlightDAO().insertCorrespondingAirports("Basel-Mulhouse-Freiburg",
				"Bucharest OTP Cluj-Napoca CLJ Sofia SOF Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Belfast", "Katowice KTW Kaunas KUN Vilnius VNO");
		new FlightDAO().insertCorrespondingAirports("Belgrade",
				"Basel-Mulhouse-Freiburg MLH Dortmund DTM Eindhoven EIN Friedrichshafen FDH Gothenburg_Landvetter GOT Hanover HAJ Karlsruhe/Baden-Baden FKB Larnaca LCA London_Luton LTN Malmo MMX Malta MLA Memmingen FMM Nuremberg NUE Paris_Beauvais BVA Stockholm_Skavsta");
		new FlightDAO().insertCorrespondingAirports("Bergen",
				"Budapest BUD Gdansk GDN Katowice KTW Kaunas KUN Riga RIX Szczecin SZZ Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Berlin Schoenefeld",
				"Chisinau KIV Cluj-Napoca CLJ Kutaisi KUT Skopje SKP Tuzla ");
		new FlightDAO().insertCorrespondingAirports("Billund",
				"Bucharest OTP Cluj-Napoca CLJ Gdansk GDN Kaunas KUN Tuzla TZL Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Birmingham",
				"Bucharest OTP Budapest BUD Poznan POZ Sofia SOF Warsaw_Chopin WAW Wroclaw WRO");
		new FlightDAO().insertCorrespondingAirports("Bologna",
				"Bucharest OTP Budapest BUD Chisinau KIV Cluj-Napoca CLJ Craiova CRA Iasi IAS Katowice KTW Sofia SOF Timisoara");
		new FlightDAO().insertCorrespondingAirports("Bourgas",
				"Budapest BUD Katowice KTW London_Luton LTN Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Bratislava", "Kyiv_Zhulyany IEV Skopje SKP Tuzla TZL");
		new FlightDAO().insertCorrespondingAirports("Bristol", "Katowice KTW Kosice KSC Sofia SOF Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Brno", "Eindhoven EIN London_Luton LTN");
		new FlightDAO().insertCorrespondingAirports("Berlin Schoenefeld",
				"Chisinau KIV Cluj-Napoca CLJ Kutaisi KUT Skopje SKP Tuzla TZL");
		new FlightDAO().insertCorrespondingAirports("Billund",
				"Bucharest OTP Cluj-Napoca CLJ Gdansk GDN Kaunas KUN Tuzla TZL Vilnius VNO Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Birmingham",
				"Bucharest sdf Budapest BUD Poznan POZ Sofia SOF Warsaw_Chopin WAW Wroclaw	WRO");
		new FlightDAO().insertCorrespondingAirports("Bologna",
				"Bucharest OTP Budapest BUD Chisinau KIV Cluj-Napoca CLJ Craiova CRA Iasi IAS Katowice KTW Sofia SOF Timisoara");
		new FlightDAO().insertCorrespondingAirports("Bourgas",
				"Budapest BUD Katowice KTW London_Luton LTN Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Bratislava", "Kyiv_Zhulyany IEV Skopje SKP Tuzla TZL");
		new FlightDAO().insertCorrespondingAirports("Bristol", "Katowice KTW Kosice KSC Sofia SOF Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Brno", "Eindhoven EIN London_Luton");
		new FlightDAO().insertCorrespondingAirports("Brussels Charleroi",
				"Bucharest OTP Budapest BUD Cluj-Napoca CLJ Gdansk GDN Ljubljana LJU Skopje SKP Sofia SOF Timisoara TSR Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Bucharest",
				"Alghero AHO Alicante ALC Barcelona_El_Prat BCN Bari BRI Basel-Mulhouse-Freiburg BSL Billund BLL Birmingham BHX Bologna BLQ Brussels_Charleroi CRL Budapest BUD Catania CTA Cluj-Napoca CLJ Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eindhoven EIN Geneva GVA Glasgow GLA Hanover HAJ Lamezia_Terme SUF Larnaca LCA Lisbon LIS London_Gatwick LGW London_Luton LTN Madrid MAD Malaga AGP Malmo MMX Malta MLA Milan_Bergamo BGY Milan_Malpensa MXP Naples NAP Nuremberg NUE Oslo_Sandefjord Torp TRF Paris_Beauvais BVA Perugia PEG Pescara PSR Pisa PSA Rome Ciampino CIA Stockholm_Skavsta NYO Tel_Aviv TLV Tenerife TFS Turin TRN Valencia VLC Venice_Treviso TSF Verona VRN Zaragoza ZAZ");
		new FlightDAO().insertCorrespondingAirports("Budapest",
				"Alghero AHO Alicante ALC Baku GYD Barcelona_El_Prat BCN Bari BRI Bergen BGO Birmingham BHX Bologna BLQ Bourgas BOJ Brussels_Charleroi CRL Bucharest OTP Catania CTA Corfu CFU Dortmund DTM Dubai DWC Eindhoven EIN Faro FAO Frankfurt_Hahn HHN Fuerteventura FUE Glasgow GLA Gothenburg_Landvetter GOT Hanover HAJ Heraklion HER Ibiza IBZ Karlsruhe/Baden-Baden FKB Kutaisi KUT Kyiv_Zhulyany IEV Lamezia_Terme SUF Lanzarote ACE Larnaca LCA Lisbon LIS Liverpool LPL London_Luton LTN Madrid MAD Malaga AGP Malmo MMX Malta MLA Milan_Malpensa MXP Moscow VKO Naples NAP Nice NCE Palma_de_Mallorca PMI Porto_Airport OPO Reykjavik KEF Rhodes RHO Riga RIX Rome_Fiumicino FCO Sofia SOF Stockholm_Skavsta NYO Targu_Mures TGM Tel_Aviv TLV Tenerife TFS Thessaloniki SKG Varna VAR Warsaw_Chopin WAW Zakynthos");
		new FlightDAO().insertCorrespondingAirports("Catania",
				"Bucharest OTP Budapest BUD Iasi IAS Katowice KTW Sofia SOF Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Chisinau",
				"Barcelona_El_Prat BCN Berlin_Schoenefeld SXF Bologna BLQ London_Luton LTN Milan_Bergamo BGY Rome_Ciampino CIA Rome_Fiumicino FCO Venice_Treviso");
		new FlightDAO().insertCorrespondingAirports("Cluj-Napoca",
				"Alicante ALC Barcelona El Prat BCN Bari BRI Basel-Mulhouse-Freiburg BSL Berlin_Schoenefeld SXF Billund BLL Bologna BLQ Brussels_Charleroi CRL Bucharest OTP Cologne CGN Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eindhoven EIN London_Luton LTN Madrid MAD Malaga AGP Malmo MMX Memmingen FMM Milan_Bergamo BGY Nuremberg NUE Palma_de_Mallorca PMI Paris_Beauvais BVA Rome_Ciampino CIA Tel_Aviv TLV Valencia VLC Venice_Treviso TSF Zaragoza");
		new FlightDAO().insertCorrespondingAirports("Cologne",
				"Cluj-Napoca CLJ Gdansk GDN Katowice KTW Kyiv_Zhulyany IEV Skopje SKP Sofia SOF Tuzla");
		new FlightDAO().insertCorrespondingAirports("Constanta", "London_Luton");
		new FlightDAO().insertCorrespondingAirports("Copenhagen", "Skopje skp Sofia sof");
		new FlightDAO().insertCorrespondingAirports("Corfu", "Budapest BUD Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Craiova",
				"Barcelona_El_Prat BCN Bologna BLQ London_Luton LTN Milan_Bergamo BGY Paris_Beauvais BVA Rome_Ciampino CIA Venice_Treviso");
		new FlightDAO().insertCorrespondingAirports("Debrecen",
				"Eindhoven EIN London_Luton LTN Malmo MMX Milan_Bergamo BGY Paris_Beauvais");
		new FlightDAO().insertCorrespondingAirports("Doncaster/Sheffield",
				"Bucharest OTP Cluj-Napoca CLJ Gdansk GDN Katowice KTW Kaunas KUN Kosice KSC Lublin LUZ Poznan POZ Riga RIX Sofia SOF Vilnius VNO Warsaw_Chopin WAW Wroclaw");
		new FlightDAO().insertCorrespondingAirports("Dortmund",
				"Belgrade BEG Bucharest OTP Budapest BUD Cluj-Napoca CLJ Gdansk GDN Katowice KTW Kaunas KUN Kutaisi KUT Kyiv_Zhulyany IEV Nis INI Riga RIX Sibiu SBZ Skopje SKP Sofia SOF Targu_Mures TGM Timisoara TSR Tuzla TZL Vilnius VNO Warsaw_Chopin WAW Wroclaw");
		new FlightDAO().insertCorrespondingAirports("Dubai",
				"Bucharest OTP Budapest BUD Cluj-Napoca CLJ Katowice KTW Sofia SOF");
		new FlightDAO().insertCorrespondingAirports("Eilat", "Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Eindhoven",
				"Belgrade BEG Brno BRQ Bucharest OTP Budapest BUD Cluj-Napoca CLJ Debrecen DEB Gdansk GDN Katowice KTW Kaunas KUN Lublin LUZ Nis INI Poznan POZ Riga RIX Skopje SKP Sofia SOF Timisoara TSR Tuzla TZL Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Faro", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Frankfurt Hahn",
				"Budapest BUD Gdansk GDN Katowice KTW Skopje SKP Sofia SOF Targu_Mures TGM Timisoara TSR Tuzla TZL Vilnius");
		new FlightDAO().insertCorrespondingAirports("Friedrichshafen", "Belgrade BEG Skopje SKP Tuzla");
		new FlightDAO().insertCorrespondingAirports("Fuerteventura", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Gdansk",
				"Aberdeen ABZ Alesund AES Barcelona_El_Prat BCN Bergen BGO Billund BLL Brussels_Charleroi CRL Cologne CGN Doncaster/Sheffield DSA Dortmund DTM Eindhoven EIN Frankfurt_Hahn HHN Glasgow GLA Gothenburg_Landvetter GOT Grenoble GNB Groningen GRQ Hamburg_Airport HAM Haugesund HAU Kristiansand KRS Kyiv_Zhulyany");
		new FlightDAO().insertCorrespondingAirports("Geneva", "Bucharest OTP Sofia");
		new FlightDAO().insertCorrespondingAirports("Glasgow",
				"Bucharest OTP Budapest BUD Gdansk GDN Katowice KTW Lublin LUZ Poznan POZ Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Gothenburg Landvetter",
				"Belgrade BEG Budapest BUD Gdansk GDN Skopje SKP Tuzla TZL Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Grenoble", "Gdansk GDN Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Groningen", "Gdansk");
		new FlightDAO().insertCorrespondingAirports("Hamburg", "Gdansk GDN Kyiv_Zhulyany IEV Skopje");
		new FlightDAO().insertCorrespondingAirports("Hanover",
				"Belgrade BEG Bucharest OTP Budapest BUD Kyiv_Zhulyany IEV Skopje");
		new FlightDAO().insertCorrespondingAirports("Haugesund", "Gdansk");
		new FlightDAO().insertCorrespondingAirports("Heraklion", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Iasi",
				"Bologna BLQ Catania CTA Larnaca LCA London_Luton LTN Milan_Bergamo BGY Rome_Ciampino CIA Rome_Fiumicino FCO Tel_Aviv TLV Venice_Treviso");
		new FlightDAO().insertCorrespondingAirports("Ibiza", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Karlsruhe/Baden-Baden", "Belgrade BEG Budapest BUD Targu_Mures");
		new FlightDAO().insertCorrespondingAirports("Katowice",
				"Alghero AHO Barcelona_El_Prat BCN Bari BRI Belfast BFS Bergen BGO Bologna BLQ Bourgas BOJ Bristol BRS Catania CTA Cologne CGN Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eindhoven EIN Frankfurt_Hahn HHN Glasgow GLA Kutaisi KUT Kyiv_Zhulyany IEV Lanzarote (ACE Larnaca LCA Lisbon LIS Liverpool LPL London_Luton LTN Maastricht_Aachen MST Malmo MMX Malta MLA Milan_Bergamo BGY Naples NAP Oslo_Sandefjord_Torp TRF Paris_Beauvais BVA Reykjavik KEF Rome_Ciampino CIA Rome_Fiumicino FCO Stavanger SVG Stockholm_Skavsta NYO Tel_Aviv TLV Tenerife");
		new FlightDAO().insertCorrespondingAirports("Kaunas",
				"Alesund AES Barcelona_El_Prat BCN Bari BRI Belfast BFS Bergen BGO Billund BLL Doncaster/Sheffield DSA Dortmund DTM Eindhoven EIN Kutaisi KUT Kyiv_Zhulyany IEV Larnaca LCA London_Luton LTN Malmo MMX Memmingen FMM Milan_Bergamo BGY Nice NCE Oslo_Sandefjord_Torp TRF Paris_Beauvais");
		new FlightDAO().insertCorrespondingAirports("Kosice", "Bristol BRS Doncaster/Sheffield DSA London_Luton");
		new FlightDAO().insertCorrespondingAirports("Kristiansand", "Gdansk");
		new FlightDAO().insertCorrespondingAirports("Kutaisi",
				"Berlin_Schoenefeld SXF Budapest BUD Dortmund DTM Katowic KTW Kaunas KUN Larnaca LCA Memmingen FMM Milan_Malpensa MXP Sofia SOF Thessaloniki SKG Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Kyiv Zhulyany",
				"Bratislava BTS Budapest BUD Cologne CGN Dortmund DTM Gdansk GDN Hamburg_Airport HAM Hanover HAJ Katowice KTW Kaunas KUN Larnaca LCA London_Luton LTN Memmingen FMM Vilnius VNO Wroclaw WRO");
		new FlightDAO().insertCorrespondingAirports("Lamezia Terme", "Bucharest OTP Budapest BUD");
		new FlightDAO().insertCorrespondingAirports("Lanzarote", "Budapest BUD Katowice KTW");
		new FlightDAO().insertCorrespondingAirports("Larnaca",
				"Belgrade BEG Bucharest OTP Budapest BUD Iasi IAS Katowice KTW Kaunas KUN Kutaisi KUT Kyiv_Zhulyany IEV Sofia SOF Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Lisbon", "Bucharest OTP Budapest BUD Katowice KTW Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Liverpool",
				"Budapest BUD Gdansk GDN Katowice KTW Lublin LUZ Riga RIX Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Ljubljana", "Brussels_Charleroi CRL London_Luton");
		new FlightDAO().insertCorrespondingAirports("London Gatwick", "Buckarest");
		new FlightDAO().insertCorrespondingAirports("London Luton",
				"Belgrade BEG Bourgas BOJ Brno BRQ Bucharest OTP Budapest BUD Chisinau KIV Cluj-Napoca CLJ Constanta CND Craiova CRA Debrecen DEB Gdansk GDN Iasi IAS Katowice KTW Kaunas KUN Kosice KSC Kyiv_Zhulyany IEV Ljubljana LJU Lublin LUZ Ohrid OHD Olsztyn-Mazury SZY Palanga PLQ Poprad/Tatry TAT Poznan POZ Prague PRG Riga RIX Satu_Mare SUJ Sibiu SBZ Skopje SKP Sofia SOF Split SPU Suceava_Airport SCV Szczecin SZZ Targu_Mures TGM Timisoara TSR Tuzla TZL Varna VAR Vilnius VNO Warsaw_Chopin WAW Wroclaw");
		new FlightDAO().insertCorrespondingAirports("Lublin",
				"Doncaster/Sheffield DSA Eindhoven EIN Glasgow GLA Liverpool LPL London_Luton LTN Oslo_Sandefjord_Torp TRF Stockholm_Skavsta");
		new FlightDAO().insertCorrespondingAirports("Maastricht Aachen", "Katowice");
		new FlightDAO().insertCorrespondingAirports("Madrid",
				"Bucharest OTP Budapest BUD Cluj-Napoca CLJ Sibiu SBZ Sofia SOF Targu_Mures TGM Timisoara");
		new FlightDAO().insertCorrespondingAirports("Malaga", "Bucharest OTP Budapest BUD Cluj-Napoca");
		new FlightDAO().insertCorrespondingAirports("Malmo",
				"Belgrade BEG Bucharest OTP Budapest BUD Cluj-Napoca CLJ Debrecen DEB Gdansk GDN Katowice KTW Kaunas KUN Nis INI Poznan POZ Skopje SKP Sofia SOF Tuzla TZL Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Malta",
				"Belgrade BEG Bucharest OTP Budapest BUD Gdansk GDN Katowice KTW Sofia SOF Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Memmingen",
				"Belgrade BEG Cluj-Napoca CLJ Kaunas KUN Kutaisi KUT Kyiv_Zhulyany IEV Nis INI Podgorica TGD Sibiu SBZ Skopje SKP Sofia SOF Targu_Mures TGM Timisoara TSR Tuzla TZL Vilnius");
		new FlightDAO().insertCorrespondingAirports("Milan Bergamo",
				"Bucharest OTP Chisinau KIV Cluj-Napoca CLJ Craiova CRA Debrecen DEB Gdansk GDN Iasi IAS Katowice KTW Kaunas KUN Podgorica TGD Prague PRG Sibiu SBZ Skopje SKP Sofia SOF Suceava_Airport SCV Timisoara TSR Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Milan Malpensa",
				"Bucharest OTP Budapest BUD Kutaisi KUT Podgorica TGD Sibiu");
		new FlightDAO().insertCorrespondingAirports("Molde", "Gdansk");
		new FlightDAO().insertCorrespondingAirports("Moscow", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Naples",
				"Bucharest OTP Budapest BUD Katowice KTW Prague PRG Sofia SOF Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Nice", "Budapest BUD Kaunas KUN Vilnius");
		new FlightDAO().insertCorrespondingAirports("Nis",
				"Basel-Mulhouse-Freiburg MLH Dortmund DTM Eindhoven EIN Malmo MMX Memmingen");
		new FlightDAO().insertCorrespondingAirports("Nuremberg",
				"Belgrade BEG Bucharest OTP Cluj-Napoca CLJ Sibiu SBZ Skopje SKP Sofia SOF Tuzla");
		new FlightDAO().insertCorrespondingAirports("Ohrid", "Basel-Mulhouse-Freiburg MLH London_Luton");
		new FlightDAO().insertCorrespondingAirports("Olsztyn-Mazury", "London_Luton LTN Oslo_Sandefjord_Torp");
		new FlightDAO().insertCorrespondingAirports("Oslo Sandefjord Torp",
				"Bucharest OTP Gdansk GDN Katowice KTW Kaunas KUN Lublin LUZ Olsztyn-Mazury SZY Poznan POZ Riga RIX Skopje SKP Szczecin SZZ Vilnius VNO Warsaw_Chopin WAW Wroclaw");
		new FlightDAO().insertCorrespondingAirports("Palanga", "London_Luton");
		new FlightDAO().insertCorrespondingAirports("Palma de Mallorca", "Budapest BUD Cluj-Napoca");
		new FlightDAO().insertCorrespondingAirports("Paris Beauvais",
				"Belgrade BEG Bucharest OTP Cluj-Napoca CLJ Craiova CRA Debrecen DEB Gdansk GDN Katowice KTW Kaunas KUN Poznan POZ Skopje SKP Sofia SOF Targu_Mures TGM Timisoara TSR Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Perugia", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Pescara", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Pisa", "Bucharest");
		new FlightDAO().insertCorrespondingAirports("Podgorica", "Memmingen FMM Milan_Bergamo BGY Milan_Malpensa MXP");
		new FlightDAO().insertCorrespondingAirports("Poprad/Tatry Airport", "London Luton");
		new FlightDAO().insertCorrespondingAirports("Porto", "Budapest BUD Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Poznan",
				"Barcelona_El_Prat BCN Birmingham BHX Doncaster/Sheffield DSA Eindhoven EIN Glasgow GLA London_Luton LTN Malmo MMX Oslo_Sandefjord_Torp TRF Paris_Beauvais BVA Stockholm_Skavsta NYO");
		new FlightDAO().insertCorrespondingAirports("Prague",
				"Bari BRI London_Luton LTN Milan_Bergamo BGY Naples NAP Rome_Ciampino CIA Rome_Fiumicino FCO Tel_Aviv TLV Venice_Treviso");
		new FlightDAO().insertCorrespondingAirports("Reykjavik",
				"Budapest BUD Gdansk GDN Katowice KTW Kaunas KUN Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Rhodes", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Riga",
				"Barcelona_El_Prat BCN Bergen BGO Budapest BUD Doncaster/Sheffield DSA Dortmund DTM Eindhoven EIN Liverpool LPL London_Luton LTN Oslo_Sandefjord_Torp TRF Tel_Aviv");
		new FlightDAO().insertCorrespondingAirports("Rome Ciampino",
				"Bucharest OTP Chisinau KIV Cluj-Napoca CLJ Craiova CRA Iasi IAS Katowice KTW Prague PRG Sofia SOF Targu_Mures TGM Timisoara");
		new FlightDAO().insertCorrespondingAirports("Rome Fiumicino",
				"Budapest BUD Chisinau KIV Gdansk GDN Iasi IAS Katowice KTW Kaunas KUN Prague PRG Sofia SOF Timisoara TSR Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Satu Mare", "London_Luton");
		new FlightDAO().insertCorrespondingAirports("Sibiu",
				"Dortmund DTM London_Luton LTN Madrid MAD Memmingen FMM Milan_Bergamo BGY Milan_Malpensa MXP Nuremberg");
		new FlightDAO().insertCorrespondingAirports("Skopje",
				"Aberdeen ABZ Alesund AES Alghero AHO Alicante ALC Baku GYD Barcelona_El_Prat BCN Bari BRI Basel-Mulhouse-Freiburg MLH Basel-Mulhouse-Freiburg BSL Belfast BFS Belgrade BEG Bergen BGO Berlin_Schoenefeld SXF Billund BLL Birmingham BHX Bologna BLQ Bourgas BOJ Bratislava BTS Bristol BRS Brno BRQ Brussels_Charleroi CRL Bucharest OTP Budapest BUD Catania CTA Chisinau KIV Cluj-Napoca CLJ Cologne CGN Constanta CND Copenhagen CPH Corfu CFU Craiova CRA Debrecen DEB Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eilat VDA Eindhoven EIN Faro FAO Frankfurt_Hahn HHN Friedrichshafen FDH Fuerteventura FUE Gdansk GDN Geneva GVA Glasgow GLA Gothenburg_Landvetter GOT Grenoble GNB Groningen GRQ Hamburg HAM Hanover HAJ Haugesund HAU Heraklion HER Iasi IAS Ibiza IBZ Karlsruhe/Baden-Baden FKB Katowice KTW Kaunas KUN Kosice KSC Kristiansand KRS Kutaisi KUT Kyiv_Zhulyany IEV Lamezia_Terme SUF Lanzarote ACE Larnaca LCA Lisbon LIS Liverpool LPL Ljubljana LJU London_Gatwick LGW London_Luton LTN Lublin LUZ Maastricht_Aachen MST Madrid MAD Malaga AGP Malmo MMX Malta MLA Memmingen FMM Milan_Bergamo BGY Milan_Malpensa MXP Molde MOL Moscow VKO Naples NAP Nice NCE Nis INI Nuremberg NUE Ohrid OHD Olsztyn-Mazury SZY Oslo_Sandefjord_Torp TRF Palanga PLQ Palma_de_Mallorca PMI Paris_Beauvais BVA Perugia PEG Pescara PSR Pisa PSA Podgorica TGD Poprad/Tatry TAT Porto OPO Poznan POZ Prague PRG Reykjavik KEF Rhodes RHO Riga RIX Rome_Ciampino CIA Rome_Fiumicino FCO Satu_Mare SUJ Sibiu SBZ Skopje SKP Sofia SOF Split SPU Stavanger SVG Stockholm_Skavsta NYO Suceava_Airport SCV Szczecin SZZ Targu_Mures TGM Tel_Aviv TLV Tenerife TFS Thessaloniki SKG Timisoara TSR Trondheim TRD Turin TRN Turku TKU Tuzla TZL Valencia VLC Varna VAR Vaxjo VXO Venice_Treviso TSF Verona VRN Vilnius VNO Warsaw_Chopin WAW Wroclaw WRO Zakynthos ZTH Zaragoza");
		new FlightDAO().insertCorrespondingAirports("Sofia",
				"Alicante ALC Barcelona_El_Prat BCN Bari BRI Basel-Mulhouse-Freiburg BSL Birmingham BHX Bologna BLQ Bristol BRS Brussels_Charleroi CRL Budapest BUD Catania CTA Cologne CGN Copenhagen CPH Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eindhoven EIN Frankfurt_Hahn HHN Geneva GVA Kutaisi KUT Larnaca LCA London_Luton LTN Madrid MAD Malmo MMX Malta MLA Memmingen FMM Milan_Bergamo BGY Naples NAP Nuremberg NUE Paris_Beauvais BVA Rome_Ciampino CIA Rome_Fiumicino FCO Tel_Aviv TLV Valencia VLC Varna");
		new FlightDAO().insertCorrespondingAirports("Split", "London_Luton LTN Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Stavanger",
				"Gdansk GDN Katowice KTW Kaunas KUN Szczecin SZZ Vilnius");
		new FlightDAO().insertCorrespondingAirports("Stockholm Skavsta",
				"Aberdeen ABZ Alesund AES Alghero AHO Alicante ALC Baku GYD Barcelona_El_Prat BCN Bari BRI Basel-Mulhouse-Freiburg MLH Basel-Mulhouse-Freiburg BSL Belfast BFS Belgrade BEG Bergen BGO Berlin_Schoenefeld SXF Billund BLL Birmingham BHX Bologna BLQ Bourgas BOJ Bratislava BTS Bristol BRS Brno BRQ Brussels_Charleroi CRL Bucharest OTP Budapest BUD Catania CTA Chisinau KIV Cluj-Napoca CLJ Cologne CGN Constanta CND Copenhagen CPH Corfu CFU Craiova CRA Debrecen DEB Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eilat VDA Eindhoven EIN Faro FAO Frankfurt_Hahn HHN Friedrichshafen FDH Fuerteventura FUE Gdansk GDN Geneva GVA Glasgow GLA Gothenburg_Landvetter GOT Grenoble GNB Groningen GRQ Hamburg HAM Hanover HAJ Haugesund HAU Heraklion HER Iasi IAS Ibiza IBZ Karlsruhe/Baden-Baden FKB Katowice KTW Kaunas KUN Kosice KSC Kristiansand KRS Kutaisi KUT Kyiv_Zhulyany IEV Lamezia_Terme SUF Lanzarote ACE Larnaca LCA Lisbon LIS Liverpool LPL Ljubljana LJU London_Gatwick LGW London_Luton LTN Lublin LUZ Maastricht_Aachen MST Madrid MAD Malaga AGP Malmo MMX Malta MLA Memmingen FMM Milan_Bergamo BGY Milan_Malpensa MXP Molde MOL Moscow VKO Naples NAP Nice NCE Nis INI Nuremberg NUE Ohrid OHD Olsztyn-Mazury SZY Oslo_Sandefjord_Torp TRF Palanga PLQ Palma_de_Mallorca PMI Paris_Beauvais BVA Perugia PEG Pescara PSR Pisa PSA Podgorica TGD Poprad/Tatry TAT Porto_Airport OPO Poznan POZ Prague PRG Reykjavik KEF Rhodes RHO Riga RIX Rome_Ciampino CIA Rome_Fiumicino FCO Satu_Mare SUJ Sibiu SBZ Skopje SKP Sofia SOF Split SPU Stavanger SVG Stockholm_Skavsta NYO Suceava_Airport SCV Szczecin SZZ Targu_Mures TGM Tel_Aviv TLV Tenerife TFS Thessaloniki SKG Timisoara TSR Trondheim TRD Turin TRN Turku TKU Tuzla TZL Valencia VLC Varna VAR Vaxjo VXO Venice_Treviso TSF Verona VRN Vilnius VNO Warsaw_Chopin WAW Wroclaw WRO Zakynthos ZTH Zaragoza");
		new FlightDAO().insertCorrespondingAirports("Suceava Airport", "London_Luton LTN Milan_Bergamo");
		new FlightDAO().insertCorrespondingAirports("Szczecin",
				"Bergen BGO London_Luton LTN Oslo_Sandefjord_Torp TRF Stavanger");
		new FlightDAO().insertCorrespondingAirports("Targu Mures",
				"Budapest BUD Dortmund DTM Frankfurt_Hahn HHN Karlsruhe/Baden-Baden FKB London_Luton LTN Madrid MAD Memmingen FMM Paris_Beauvais BVA Rome_Ciampino CIA");
		new FlightDAO().insertCorrespondingAirports("Tel Aviv",
				"Bucharest OTP Budapest BUD Cluj-Napoca CLJ Iasi IAS Katowice KTW Kaunas KUN Prague PRG Riga RIX Sofia SOF Vilnius VNO Warsaw_Chopin");
		new FlightDAO().insertCorrespondingAirports("Tenerife", "Bucharest OTP Budapest BUD Katowice");
		new FlightDAO().insertCorrespondingAirports("Thessaloniki", "Budapest BUD Kutaisi KUT");
		new FlightDAO().insertCorrespondingAirports("Timisoara",
				"Aberdeen ABZ Alesund AES Alghero AHO Alicante ALC Baku GYD Barcelona_El_Prat BCN Bari BRI Basel-Mulhouse-Freiburg MLH Basel-Mulhouse-Freiburg BSL Belfast BFS Belgrade BEG Bergen BGO Berlin_Schoenefeld SXF Billund BLL Birmingham BHX Bologna BLQ Bourgas BOJ Bratislava BTS Bristol BRS Brno BRQ Brussels_Charleroi CRL Bucharest OTP Budapest BUD Catania CTA Chisinau KIV Cluj-Napoca CLJ Cologne CGN Constanta CND Copenhagen CPH Corfu CFU Craiova CRA Debrecen DEB Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eilat VDA Eindhoven EIN Faro FAO Frankfurt_Hahn HHN Friedrichshafen FDH Fuerteventura FUE Gdansk GDN Geneva GVA Glasgow GLA Gothenburg_Landvetter GOT Grenoble GNB Groningen GRQ Hamburg_Airport HAM Hanover HAJ Haugesund HAU Heraklion hrk Iasi IAS Ibiza IBZ Karlsruhe/Baden-Baden FKB Katowice KTW Kaunas KUN Kosice KSC Kristiansand KRS Kutaisi KUT Kyiv_Zhulyany IEV Lamezia_Terme SUF Lanzarote ACE Larnaca LCA Lisbon LIS Liverpool LPL Ljubljana LJU London_Gatwick LGW London_Luton LTN Lublin LUZ Maastricht_Aachen MST Madrid MAD Malaga AGP Malmo MMX Malta MLA Memmingen FMM Milan_Bergamo BGY Milan_Malpensa MXP Molde MOL Moscow VKO Naples NAP Nice NCE Nis INI Nuremberg NUE Ohrid OHD Olsztyn-Mazury SZY Oslo_Sandefjord_Torp TRF Palanga PLQ Palma_de_Mallorca PMI Paris_Beauvais BVA Perugia PEG Pescara PSR Pisa PSA Podgorica TGD Poprad/Tatry TAT Porto OPO Poznan POZ Prague PRG Reykjavik KEF Rhodes RHO Riga RIX Rome_Ciampino CIA Rome_Fiumicino FCO Satu_Mare SUJ Sibiu SBZ Skopje SKP Sofia SOF Split SPU Stavanger SVG Stockholm Skavsta NYO Suceava SCV Szczecin SZZ Targu_Mures TGM Tel_Aviv TLV Tenerife TFS Thessaloniki SKG Timisoara TSR Trondheim TRD Turin TRN Turku TKU Tuzla TZL Valencia VLC Varna VAR Vaxjo VXO Venice_Treviso TSF Verona VRN Vilnius VNO Warsaw_Chopin WAW Wroclaw WRO Zakynthos ZTH Zaragoza ZAZ");
		new FlightDAO().insertCorrespondingAirports("Trondheim", "Gdansk");
		new FlightDAO().insertCorrespondingAirports("Turin", "Bucharest OTP Warsaw_Chopin WAW");
		new FlightDAO().insertCorrespondingAirports("Turku", "Gdansk");
		new FlightDAO().insertCorrespondingAirports("Tuzla",
				"Basel-Mulhouse-Freiburg MLH Berlin_Schoenefeld SXF Billund BLL Bratislava BTS Cologne CGN Dortmund DTM Eindhoven EIN Frankfurt_Hahn HHN Friedrichshafen FDH Gothenburg_Landvetter GOT London_Luton LTN Malmo MMX Memmingen FMM Nuremberg NUE Stockholm_Skavsta NYO Vaxjo VXO");
		new FlightDAO().insertCorrespondingAirports("Valencia",
				"Bucharest OTP Cluj-Napoca CLJ Sofia SOF Timisoara TSR");
		new FlightDAO().insertCorrespondingAirports("Varna", "Budapest BUD London_Luton LTN Sofia SOF");
		new FlightDAO().insertCorrespondingAirports("Vaxjo", "Tuzla");
		new FlightDAO().insertCorrespondingAirports("Venice Treviso",
				"Bucharest OTP Chisinau KIV Cluj-Napoca CLJ Craiova CRA Iasi IAS Prague PRG Skopje SKP Timisoara TSR");
		new FlightDAO().insertCorrespondingAirports("Verona",
				"Chisinau KIV Cluj-Napoca CLJ Kutaisi KUT Skopje SKP Tuzla TZL");
		new FlightDAO().insertCorrespondingAirports("Vilnius",
				"Alesund AES Barcelona_El_Prat BCN Bari BRI Belfast BFS Bergen BGO Billund BLL Doncaster/Sheffield DSA Dortmund DTM Eindhoven EIN Frankfurt_Hahn HHN Grenoble GNB Kutaisi KUT Kyiv_Zhulyany IEV Larnaca LCA London_Luton LTN Malmo MMX Memmingen FMM Milan_Bergamo BGY Nice NCE Oslo_Sandefjord_Torp TRF Paris_Beauvais BVA Reykjavik KEF Rome_Fiumicino FCO Stavanger SVG Stockholm_Skavsta NYO Tel_Aviv TLV");
		new FlightDAO().insertCorrespondingAirports("Warsaw Chopin",
				"Aberdeen ABZ Alesund AES Alghero AHO Alicante ALC Baku GYD Barcelona_El_Prat BCN Bari BRI Basel-Mulhouse-Freiburg MLH Basel-Mulhouse-Freiburg BSL Belfast BFS Belgrade BEG Bergen BGO Berlin_Schoenefeld SXF Billund BLL Birmingham BHX Bologna BLQ Bourgas BOJ Bratislava BTS Bristol BRS Brno BRQ Brussels_Charleroi CRL Bucharest OTP Budapest BUD Catania CTA Chisinau KIV Cluj-Napoca CLJ Cologne CGN Constanta CND Copenhagen CPH Corfu CFU Craiova CRA Debrecen DEB Doncaster/Sheffield DSA Dortmund DTM Dubai DWC Eilat VDA Eindhoven EIN Faro FAO Frankfurt_Hahn HHN Friedrichshafen FDH Fuerteventura FUE Gdansk GDN Geneva GVA Glasgow GLA Gothenburg_Landvetter GOT Grenoble GNB Groningen GRQ Hamburg_Airport HAM Hanover HAJ Haugesund HAU Heraklion HER Iasi IAS Ibiza IBZ Karlsruhe/Baden-Baden FKB Katowice KTW Kaunas KUN Kosice KSC Kristiansand KRS Kutaisi KUT Kyiv_Zhulyany IEV Lamezia_Terme SUF Lanzarote ACE Larnaca LCA Lisbon LIS Liverpool LPL Ljubljana LJU London_Gatwick LGW London_Luton LTN Lublin LUZ Maastricht_Aachen MST Madrid MAD Malaga AGP Malmo MMX Malta MLA Memmingen FMM Milan_Bergamo BGY Milan_Malpensa MXP Molde MOL Moscow VKO Naples NAP Nice NCE Nis INI Nuremberg NUE Ohrid OHD Olsztyn-Mazury SZY Oslo_Sandefjord_Torp TRF Palanga PLQ Palma_de_Mallorca PMI Paris_Beauvais BVA Perugia PEG Pescara PSR Pisa PSA Podgorica TGD Poprad/Tatry TAT Porto_Airport OPO Poznan POZ Prague PRG Reykjavik KEF Rhodes RHO Riga RIX Rome_Ciampino CIA Rome_Fiumicino FCO Satu_Mare SUJ Sibiu SBZ Skopje SKP Sofia SOF Split SPU Stavanger SVG Stockholm_Skavsta NYO Suceava_Airport SCV Szczecin SZZ Targu_Mures TGM Tel_Aviv TLV Tenerife TFS Thessaloniki SKG Timisoara TSR Trondheim TRD Turin TRN Turku TKU Tuzla TZL Valencia VLC Varna VAR Vaxjo VXO Venice_Treviso TSF Verona VRN Vilnius VNO Warsaw_Chopin WAW Wroclaw WRO Zakynthos ZTH Zaragoza ZAZ");
		new FlightDAO().insertCorrespondingAirports("Wroclaw",
				"Birmingham BHX Doncaster/Sheffield DSA Dortmund DTM Eindhoven EIN Kyiv_Zhulyany IEV London_Luton LTN Oslo_Sandefjord_Torp TRF Stockholm_Skavsta NYO");
		new FlightDAO().insertCorrespondingAirports("Zakynthos", "Budapest");
		new FlightDAO().insertCorrespondingAirports("Zaragoza", "Bucharest OTP Cluj-Napoca CLJ");

	}
}
