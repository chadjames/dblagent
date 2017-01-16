var mymap = L.map('mapid').setView([39.8282, -98.5795], 5);
var doubleAgentEndpoint = 'https://chadjames-doubleagent.herokuapp.com/';
var femaleIconColor = 'pink';
var maleIconColor = 'blue';
var pinkMarker = L.AwesomeMarkers.icon({
    icon:           'barcode',
    markerColor:    femaleIconColor
});
var blueMarker = L.AwesomeMarkers.icon({
    icon:           'barcode',
    markerColor:    maleIconColor
});
var activeGenderFilter;
var activeAgeFilter;

var markers = new L.FeatureGroup();
var filteredMarkers = new L.FeatureGroup();

window.onload = function() {
    L.tileLayer('https://api.mapbox.com/styles/v1/chadjames/cixtqxcil001z2rrsuqnvxq46/tiles/256/{z}/{x}/{y}?access_token=pk.eyJ1IjoiY2hhZGphbWVzIiwiYSI6ImNpeHRxd2ZjNjAwNXUzM29jN3ByMTdtYWQifQ.pJX_EnT0qa5LDvzDEIM0hA', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
        maxZoom: 36,
        id: 'mapbox.satellite',
        accessToken: 'pk.eyJ1IjoiY2hhZGphbWVzIiwiYSI6ImNpeHRxd2ZjNjAwNXUzM29jN3ByMTdtYWQifQ.pJX_EnT0qa5LDvzDEIM0hA'
    }).addTo(mymap);
    connect();
};

function loadDoubleAgents(filter) {
    mymap.removeLayer(markers);
    mymap.removeLayer(filteredMarkers);

    markers = new L.FeatureGroup();
    filteredMarkers = new L.FeatureGroup();
    activeFilter = null;
    var url = doubleAgentEndpoint + '?filter=' + filter;
    $.ajax({
        url: url
    }).then(function (data) {
        console.log(data);
        data.doubleAgents.forEach(function (doubleAgent) {

            markers.addLayer(L.marker([doubleAgent.currentLatitude, doubleAgent.currentLongitude],
                {icon: doubleAgent.gender === 'Male' ? blueMarker : pinkMarker})
                .bindPopup(
                    'Name: '    + doubleAgent.name          + '<br>' +
                    'Gender: '  + doubleAgent.gender        + '<br>' +
                    'Age: '     + doubleAgent.age           + '<br>' +
                    '<button onclick=subscribe('+ doubleAgent.id +')' +
                    ' type="button"' +
                    ' class="chat-btn btn'      +
                    ' btn-link">Assume Identity</button>'   + '<br>' +
                    '<button onclick=messageAgent('+ doubleAgent.id +')' +
                    ' type="button"' +
                    ' class="chat-btn btn'      +
                    ' btn-link">Message Agent</button>'   + '<br>'
                    )
                .openPopup())


        });
        mymap.addLayer(markers);
    });


}
function assumeId(id) {
    console.log("assumeId " + id);
    subscribe(id);
}

function filterMarkers(filter){
    activeGenderFilter = filter;
    mymap.removeLayer(markers);
    mymap.removeLayer(filteredMarkers);

    if(filter === 'All'){
        mymap.addLayer(markers);
        return;
    }

    filteredMarkers = new L.FeatureGroup();
    var iconColor = filter === 'Female' ? femaleIconColor : maleIconColor;
    Object.keys(markers._layers).forEach(function(key,value){
        if(markers._layers[key].options.icon.options.markerColor === iconColor){
            filteredMarkers.addLayer(markers._layers[key]);
        }
    });
    mymap.addLayer(filteredMarkers);
}

function filterMaxAge(filter){
    activeAgeFilter = filter;

    mymap.removeLayer(markers);
    mymap.removeLayer(filteredMarkers);


    filteredMarkers = new L.FeatureGroup();

    var maxAge = parseInt(filter);
    Object.keys(markers._layers).forEach(function(key,value) {
        var age = parseInt(markers._layers[key]._popup._content.split('Age:')[1]);
        if (age <= maxAge) {
            filteredMarkers.addLayer(markers._layers[key]);
        }
    });
    mymap.addLayer(filteredMarkers);

}

$(function () {

    $("#loadDoubleAgents").click(function () {
        loadDoubleAgents();
    });
    $("#max-age-form").submit(function (event) {
        event.preventDefault();
        filterMaxAge($('#max_age').val());
    });
    $("#chat-text-area-submit").submit(function (event) {
        event.preventDefault();
        send();
    });
    $(".dropdown-menu").on("click", "a", function (event) {
        filterMarkers(event.target.innerText);
    });


});

