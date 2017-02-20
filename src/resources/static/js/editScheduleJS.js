$(document).ready(function() {
    $('#calendar').fullCalendar({
        header: {
            left: 'prev, next today',
            center: 'title',
            right: 'agendaWeek,agendaDay,listWeek, month, listDay, listYear'
        },
        views: {
            listDay: { buttonText: 'list day' },
            listWeek: { buttonText: 'list week' }
        },
        defaultView: 'agendaWeek',
        events: [
            {
                title: 'Event1',
                start: '2017-02-11'
            }
        ],
        dayClick: function(date, jsEvent, view, resourceObj) {
            alert('Date: ' + date.format());
            alert('Resource ID: ' + resourceObj.id);
        },
        eventClick: function(event, element) {
            event.title = "CLICKED!";
            $('#calendar').fullCalendar('updateEvent', event);
        }
    })
});