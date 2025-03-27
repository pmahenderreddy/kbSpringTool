const fs = require('fs');
const path = require('path');

// Path to the folder containing video files
const folderPath = '.';

// Read all files in the directory
fs.readdir(folderPath, (err, files) => {
    if (err) {
        console.error('Error reading the folder:', err);
        return;
    }

    files.forEach(file => {
        const match = file.match(/^video-(\d+)\.mp4$/); // Match files like video-1.mp4, video-10.mp4
        if (match) {
            const num = parseInt(match[1], 10);

            // Add leading zeros only if less than 100
            const newNum = num < 100 ? String(num).padStart(3, '0') : num;
            
            const oldPath = path.join(folderPath, file);
            const newPath = path.join(folderPath, `video-${newNum}.mp4`);

            // Rename the file
            fs.rename(oldPath, newPath, (err) => {
                if (err) {
                    console.error(`Error renaming ${file}:`, err);
                } else {
                    console.log(`Renamed: ${file} → video-${newNum}.mp4`);
                }
            });
        }
    });
});

