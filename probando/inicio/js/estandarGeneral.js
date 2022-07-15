/* RELOJ */

var reloj = document.getElementById('reloj');
var mostrarReloj = function(){

var miReloj = new Date();
var hora = miReloj.getHours();
var minuto = miReloj.getMinutes();
var segundo = miReloj.getSeconds();
if(hora < 10){
    hora = "0" + hora;
}
if(minuto < 10){
    minuto = "0" + minuto;
}
    if(segundo < 10){
    segundo = "0" + segundo;
}

reloj.textContent = hora + ":" + minuto + ":" + segundo;
}
setInterval(mostrarReloj, 1000);



/* NAVBAR */
const menuToggle = document.querySelector('.menu-toggle');
const navigation = document.querySelector('.navigation');
menuToggle.onclick = () => {
    navigation.classList.toggle('open');
}

const listItems = document.querySelectorAll('.list-item');
listItems.forEach(item => {
    item.onclick = () => {
    listItems.forEach(item => item.classList.remove('active'));
    item.classList.add('active');
    }
})



/* CALENDARIO */
function adjustedMonth(month) {
    if (month < 0)
        month += 12
    else if (month > 11)
        month -= 12
    return month
}

function calendarDaysJS(dateForMonth) {
    const days = []
    const tempDate = new Date(dateForMonth.getTime())
    tempDate.setDate(1)
    tempDate.setDate(1 - tempDate.getDay())
    for (let i = 1; i <= 42; i++) {
        days[i] = { day: tempDate.getDate(), month: tempDate.getMonth(), year: tempDate.getFullYear() }
        tempDate.setDate(tempDate.getDate() + 1)
    }
    return days
}

function dateClass(item, month, today) {
    let className = item.month === month ? "active-day" : "inactive-day"

    if (item.day === today.getDate() && item.month === today.getMonth() && item.year === today.getFullYear()) {
        className += " current"
    }
    className += " date"
    return className
}

function changeMonth(number, dateForMonth) {
    dateForMonth.setMonth(dateForMonth.getMonth() + number, 1)
}

const months = ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"];
const days = ["D", "L", "M", "M", "J", "V", "S"];
const today = new Date();
const dateForMonth = new Date(today.getTime());

days.forEach((day) => {
    const daySpan = document.createElement('span')
    daySpan.textContent = day;
    document.querySelector('.calendar-days').appendChild(daySpan)
})

function renderCalendar() {
    document.querySelector('.calendar-year').textContent = dateForMonth.getFullYear();

    document.querySelector('.current-month').textContent = months[dateForMonth.getMonth()]

    document.querySelector('.inactive-month:first-child').textContent = months[adjustedMonth(dateForMonth.getMonth() - 1)]

    document.querySelector('.inactive-month:last-child').textContent = months[adjustedMonth(dateForMonth.getMonth() + 1)]

    document.querySelectorAll('.date').forEach(node => node.remove())
    calendarDaysJS(dateForMonth).forEach((item) => {
        const dateDiv = document.createElement('div')
        dateDiv.setAttribute('class', dateClass(item, dateForMonth.getMonth(), today))
        const dateSpan = document.createElement('span')
        dateSpan.textContent = item.day
        dateDiv.appendChild(dateSpan)
        document.querySelector('.calendar-dates').appendChild(dateDiv)
    })
}

document.querySelector('.calendar-arrow:first-child').addEventListener('click', e => {
    changeMonth(-1, dateForMonth)
    renderCalendar()
})

document.querySelector('.calendar-arrow:last-child').addEventListener('click', e => {
    changeMonth(1, dateForMonth)
    renderCalendar()
})

renderCalendar()