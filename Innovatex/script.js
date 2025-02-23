document.addEventListener("DOMContentLoaded", function () {
    fetch("data.json")
        .then(response => response.json())
        .then(data => {
            displaySpeakers(data.speakers);
            displaySchedule(data.schedule);
        })
        .catch(error => console.error("Error loading JSON data:", error));
});

function displaySpeakers(speakers) {
    const speakersSection = document.getElementById("speakers-list");
    if (!speakersSection) return;

    speakers.forEach(speaker => {
        const speakerElement = document.createElement("div");
        speakerElement.classList.add("speaker");

        speakerElement.innerHTML = `
            <img src="${speaker.image}" alt="${speaker.name}" class="speaker-img">
            <div class="speaker-info">
                <h3>${speaker.name}</h3>
                <p><strong></strong> ${speaker.qualification}</p>
                <p><strong>Topic:</strong> ${speaker.topic}</p>
                <p><strong>Time:</strong> ${speaker.time}</p>
            </div>
        `;

        speakersSection.appendChild(speakerElement);
    });
}

function displaySchedule(schedule) {
    const scheduleSection = document.getElementById("schedule-list");
    if (!scheduleSection) return;

    schedule.forEach(day => {
        const dayElement = document.createElement("div");
        dayElement.classList.add("schedule-day");
        dayElement.innerHTML = `<h2>${day.day}</h2>`;

        day.sessions.forEach(session => {
            const sessionElement = document.createElement("p");
            sessionElement.innerHTML = `<strong>${session.time}:</strong> ${session.title}`;
            dayElement.appendChild(sessionElement);
        });

        scheduleSection.appendChild(dayElement);
    });
}
