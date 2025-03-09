const fs = require("fs");

var data = fs.readFileSync("./download.har", "utf8");
var bigData = true;

if (!bigData) {
  parsedData = {
    person: [
      { name: "John", age: 25 },
      { name: "Jane", age: 28 },
    ],
  };

  //Log the structure of parsedData
  console.log(parsedData);
} else {
	const part1 = "ffmpeg -i \"";
	const part3 = "\" -c copy -bsf:a aac_adtstoasc video-";
	const part5 = ".mp4";
	
	let nr=1;//1
	
  const parsedData = JSON.parse(data);
  var object = parsedData.log.entries;
  for (const key in object) {
    if (Object.prototype.hasOwnProperty.call(object, key)) {
      const entry = object[key];
      if (entry.response.status == 200) {
        if (entry.request.url.indexOf("index.m3u8") !== -1) {
		  // url: entry.request.url
		  let httpUrl = entry.request.url;
		  let fmtNr = nr.toString().padStart(3, '0');
		  let ndLink = part1 + httpUrl + part3 + fmtNr + part5;
          console.log( ndLink );
		  nr++;
        }
      }
    }
  }
}


/*

document.querySelectorAll("li > section > article > h6 > a").forEach(a => {
    if (a.textContent.trim().toLowerCase() === "practice quiz") {
        const liElement = a.closest("li"); // Find the closest <li> ancestor
        if (liElement) {
            liElement.remove();
        }
    }
});


let items = document.querySelectorAll("#content-panel > section > article > section > div > section > div > aside > section > div > div > ol > li > ol > li > section > article > h6 > a");

// Function to click each element with a 10-second interval
const clickItemsWithInterval = () => {
    let index = 0;

    // Function to click an item
    const clickItem = () => {
        console.log("in method....");
        if (index < items.length) {
            
                console.log("Loading..."+items[index].innerHTML);
                items[index].click();  // Click the item
                index++;
                setTimeout(clickItem, 8000); // Call next click after 8 seconds
    			console.log("index: "+index);
            
        }
    };

    // Start the clicking process
    clickItem();
};

// Start the clicking process
clickItemsWithInterval();


 */
