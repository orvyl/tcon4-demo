const API_URL = 'http://localhost:8080';

const getPositions = function(handle) {
    fetch(API_URL + '/candidate/positions', {
        method: 'GET',
    })
    .then(function (response) {
        return response.json();
    })
    .then(function (positions) {
        handle(positions)
    })
    .catch(function(error) {
        alert('ERR!' + error)
    })
}


const getCandidate = function (id, handle) {
    fetch(API_URL + '/candidate/' + id, {
        method: 'GET',
    })
    .then(function (response) {
        return response.json();
    })
    .then(function (candidate) {
        handle(candidate)
    })
    .catch(function (error) {
        alert('ERR!' + error)
    })
}

const getCandidateList = function (handle) {
    fetch(API_URL + '/candidate', {
        method: 'GET',
    })
    .then(function (response) {
        return response.json();
    })
    .then(function (candidates) {
        handle(candidates)
    })
    .catch(function (error) {
        alert('ERR!' + error)
    })
}

const getQueryParam = function (key) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(key);
}

const createLink = function (label, href) {
    var a = document.createElement('a');
    var linkText = document.createTextNode(label);
    a.appendChild(linkText);
    a.href = href;
    return a
}