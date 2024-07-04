// package com.example.soap;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.soap.wsdl.Country;
// import com.example.soap.wsdl.GetCountryRequest;
// import com.example.soap.wsdl.GetCountryResponse;

// @RestController
// public class CountryController {
    
//     @Autowired
//     CountryClient client;
    
//     @PostMapping("/api/country")
//     public ResponseEntity<Country> sendEmail(@RequestBody GetCountryRequest request) throws Exception{
        
//         GetCountryResponse response = client.getCountry(request.getName());
//         return ResponseEntity.ok(response.getCountry());
//     }
// }