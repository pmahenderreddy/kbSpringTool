const fs = require("fs");

var data = fs.readFileSync("./download.har", "utf8");

// Get command line arguments (excluding Node.js path and script path)
const args = process.argv.slice(2);
let linesPerFile = 10;

if (args.length > 0) {
	linesPerFile = parseInt(args[0], 10);
	if(linesPerFile <= 0) {
		linesPerFile = 10;
	}
}

const part1 = "ffmpeg -i \"";
const part3 = "\" -c copy -bsf:a aac_adtstoasc video-";
const part5 = ".mp4";

let nr = 1;//1

const parsedData = JSON.parse(data);
var object = parsedData.log.entries;


// Function to write lines to files in chunks of 2
function writeLinesInChunks(lines, linesPerFile) {
	let fileNr = 0;
	let fileNames = "";
	const encoding = 'utf8';
	const newLine = "\n";
	const exit = "exit";

	for (let i = 0; i < lines.length; i += linesPerFile) {
		// Slice the lines to get 2 lines at a time
		const chunk = lines.slice(i, i + linesPerFile);

		// Create a new file for each chunk
		const fileName = `file-part-${++fileNr}.bat`;
		fileNames += `start "" ${fileName}${newLine}`;

		// Write the chunk to the corresponding file
		fs.writeFileSync(fileName, chunk.join(newLine), encoding);
		fs.appendFileSync(fileName, `${newLine} ${exit}`, encoding);
	}

	if (fileNr > 0) {
		fs.appendFileSync("runAll.bat", fileNames + `${exit}`, encoding);
	}
}

let lines = [];
for (const key in object) {
	if (Object.prototype.hasOwnProperty.call(object, key)) {
		const entry = object[key];
		if (entry.response.status == 200) {
			if (entry.request.url.indexOf("index.m3u8") !== -1) {
				// url: entry.request.url
				let httpUrl = entry.request.url;
				let fmtNr = nr.toString().padStart(3, '0');
				let ndLink = part1 + httpUrl + part3 + fmtNr + part5;
				console.log(ndLink);

				lines.push(ndLink);
				nr++;
			}
		}
	}
}
// Call the function to write lines to files
writeLinesInChunks(lines, linesPerFile);



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
