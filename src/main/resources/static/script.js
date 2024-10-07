async function convertLength(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    const form = document.getElementById('lengthForm');
    const formData = new FormData(form);
    const conversionRequest = {
        value: parseFloat(formData.get('value')), // Ensure the value is a number
        fromUnit: formData.get('fromUnit'),
        toUnit: formData.get('toUnit')
    };

    const response = await fetch('/length', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(conversionRequest)
    });

    if (response.ok) {
        const conversionResponse = await response.json(); // Get the JSON response
        // Format and display the result
        document.getElementById('resultText').innerText =
            `${conversionResponse.originalValue} ${conversionResponse.fromUnit} = ${conversionResponse.convertedValue.toFixed(2)} ${conversionResponse.toUnit}`;
        document.getElementById('result').style.display = 'block'; // Show the result
        document.getElementById('resetButton').style.display = 'block'; // Show reset button
    } else {
        alert('Conversion failed. Please try again.');
    }
}

async function convertWeight(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    const form = document.getElementById('weightForm');
    const formData = new FormData(form);
    const conversionRequest = {
        value: parseFloat(formData.get('value')),
        fromUnit: formData.get('fromUnit'),
        toUnit: formData.get('toUnit')
    };

    const response = await fetch('/weight', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(conversionRequest)
    });

    if (response.ok) {
        const conversionResponse = await response.json();
        document.getElementById('weightResultText').innerText =
            `${conversionResponse.originalValue} ${conversionResponse.fromUnit} = ${conversionResponse.convertedValue.toFixed(2)} ${conversionResponse.toUnit}`;
        document.getElementById('weightResult').style.display = 'block'; // Show the result
        document.getElementById('weightResetButton').style.display = 'block'; // Show reset button
    } else {
        alert('Conversion failed. Please try again.');
    }
}

async function convertTemperature(event) {
    event.preventDefault(); // Prevent the form from submitting normally

    const form = document.getElementById('temperatureForm');
    const formData = new FormData(form);
    const conversionRequest = {
        value: parseFloat(formData.get('value')),
        fromUnit: formData.get('fromUnit'),
        toUnit: formData.get('toUnit')
    };

    const response = await fetch('/temperature', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(conversionRequest)
    });

    if (response.ok) {
        const conversionResponse = await response.json();
        document.getElementById('temperatureResultText').innerText =
            `${conversionResponse.originalValue} ${conversionResponse.fromUnit} = ${conversionResponse.convertedValue.toFixed(2)} ${conversionResponse.toUnit}`;
        document.getElementById('temperatureResult').style.display = 'block'; // Show the result
        document.getElementById('temperatureResetButton').style.display = 'block'; // Show reset button
    } else {
        alert('Conversion failed. Please try again.');
    }
}

function resetForm() {
    document.getElementById('lengthForm').reset();
    document.getElementById('result').style.display = 'none'; // Hide result
    document.getElementById('resetButton').style.display = 'none'; // Hide reset button
}

function resetWeightForm() {
    document.getElementById('weightForm').reset();
    document.getElementById('weightResult').style.display = 'none'; // Hide result
    document.getElementById('weightResetButton').style.display = 'none'; // Hide reset button
}

function resetTemperatureForm() {
    document.getElementById('temperatureForm').reset();
    document.getElementById('temperatureResult').style.display = 'none'; // Hide result
    document.getElementById('temperatureResetButton').style.display = 'none'; // Hide reset button
}

// Functions to show/hide converters
function showLengthConverter() {
    hideAllConverters();
    document.getElementById('length').style.display = 'block';
}

function showWeightConverter() {
    hideAllConverters();
    document.getElementById('weight').style.display = 'block';
}

function showTemperatureConverter() {
    hideAllConverters();
    document.getElementById('temperature').style.display = 'block';
}

function hideAllConverters() {
    document.getElementById('length').style.display = 'none';
    document.getElementById('weight').style.display = 'none';
    document.getElementById('temperature').style.display = 'none';
}

// Initially show only length converter
showLengthConverter();
