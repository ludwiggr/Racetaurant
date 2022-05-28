import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import PriceCategory from '../model/priceCategory';
import Cuisine from '../model/cuisine';
import { useTheme, Rating, SelectChangeEvent, Theme, Input } from '@mui/material';
import FilterCuisine from './filterCuisine';
import Slider from '@mui/material/Slider';

export interface FilterProps {
    filter: {
        price: PriceCategory, //done
        latitude?: number,
        longitude?: number,
        radius?: number,
        cuisines: Array<Cuisine>, //done
        rating_min?: number,
        rating_max?: number,
        time_start?: Date,
        time_stop?: Date,
        persons?: number,
    },
    setFilter: React.Dispatch<React.SetStateAction<{
        price: PriceCategory, //done
        latitude?: number,
        longitude?: number,
        radius?: number,
        cuisines: Array<Cuisine>, //done
        rating_min?: number, //odne
        rating_max?: number, //done
        time_start?: Date, //done
        time_stop?: Date, // done
        persons?: number, //done
    }>>
}


const times: Date[] = [
    new Date('2013-08-03T00:00:00'),
    new Date('2013-08-03T01:00:00'),
    new Date('2013-08-03T02:00:00'),
    new Date('2013-08-03T03:00:00'),
    new Date('2013-08-03T04:00:00'),
    new Date('2013-08-03T05:00:00'),
    new Date('2013-08-03T06:00:00'),
    new Date('2013-08-03T07:00:00'),
    new Date('2013-08-03T08:00:00'),
    new Date('2013-08-03T09:00:00'),
    new Date('2013-08-03T10:00:00'),
    new Date('2013-08-03T11:00:00'),
    new Date('2013-08-03T12:00:00'),
    new Date('2013-08-03T13:00:00'),
    new Date('2013-08-03T14:00:00'),
    new Date('2013-08-03T15:00:00'),
    new Date('2013-08-03T16:00:00'),
    new Date('2013-08-03T17:00:00'),
    new Date('2013-08-03T18:00:00'),
    new Date('2013-08-03T19:00:00'),
    new Date('2013-08-03T20:00:00'),
    new Date('2013-08-03T21:00:00'),
    new Date('2013-08-03T22:00:00'),
    new Date('2013-08-03T23:00:00'),
    new Date('2013-08-03T23:59:00'),
]



const Filter: React.FC<FilterProps> = ({ filter, setFilter }) => {
    const range = (start: number = 0, end: number = 5) => Array.from({ length: ((end + 1) - start) }, (v, k) => k + start);
    const rangeDate = (start: Date = times[0], end: Date = times[times.length - 1]) => Array.from({ length: (times.indexOf(end) - times.indexOf(start) + 1) }, (v, k) => k + times.indexOf(start))

    const parsePrice = (n: number): PriceCategory => {
        switch (n) {
            case 0:
                return 0
            case 1:
                return 1
            case 2:
                return 2
            default:
                return 1;
        }
    };

    const handlePriceCategory = (
        event: React.ChangeEvent<HTMLInputElement>,
    ) => {
        setFilter({
            ...filter,
            price: parsePrice(parseInt(event.target.value))
        })
    }

    const handleMinRating = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFilter({
            ...filter,
            rating_min: parseInt(event.target.value)
        })
    }

    const handleMaxRating = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFilter({
            ...filter,
            rating_max: parseInt(event.target.value)
        })
    }

    const handleTimeStart = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFilter({
            ...filter,
            time_start: times[parseInt(event.target.value)]
        })
    }

    const handleTimeStop = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFilter({
            ...filter,
            time_stop: times[parseInt(event.target.value)]
        })
    }

    const handleAmountPerson = (event: Event, value: number | number[], activeThumb: number) => {
        setFilter({
            ...filter,
            persons: activeThumb
        })
    }

    const handleLong = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFilter({
            ...filter,
            longitude: parseInt(event.target.value)
        })
    }
    const handleLat = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFilter({
            ...filter,
            latitude: parseInt(event.target.value)
        })
    }
    const handleRadius = (event: React.ChangeEvent<HTMLInputElement>) => {
        setFilter({
            ...filter,
            radius: parseInt(event.target.value)
        })
    }


    console.log(filter)
    return (
        <Box
            component="form"
            sx={{
                '& .MuiTextField-root': {
                    m: 1, alignItems: 'center', maxWidth: 300
                },
            }}
            noValidate
            pt={3}
            autoComplete="off"
        >
            <div>
                <FilterCuisine filter={filter} setFilter={setFilter} />
                <TextField
                    fullWidth={true}
                    id="preis-select"
                    select
                    label="Preis"
                    value={filter["price"]}
                    onChange={handlePriceCategory}
                // helperText="Wähle die Preisstufe"
                >
                    <MenuItem value={0}>€</MenuItem>
                    <MenuItem value={1}>€€</MenuItem>
                    <MenuItem value={2}>€€€</MenuItem>
                </TextField>
            </div>
            <div>
                <TextField
                    id="rating_min-select"
                    fullWidth={true}
                    select
                    label="rating_min"
                    value={filter["rating_min"]}
                    onChange={handleMinRating}
                    helperText="Bitte wähle ein Rating"
                >
                    {
                        range(0, filter["rating_max"]).map(value => (
                            <MenuItem key={value + "min"} value={value}>
                                <Rating name="read-only" value={value} readOnly />
                            </MenuItem>
                        ))
                    }
                </TextField>
                <TextField
                    id="rating_max-select"
                    fullWidth={true}
                    select
                    label="rating_max"
                    value={filter["rating_max"]}
                    onChange={handleMaxRating}
                    helperText="Bitte wähle maximum"
                >
                    {
                        range(filter["rating_min"], 5).map(value => (
                            <MenuItem key={value + "max"} value={value}>
                                <Rating name="read-only" value={value} readOnly />
                            </MenuItem>
                        ))
                    }

                </TextField>
            </div>
            <div>
                <TextField
                    id="time_start-select"
                    fullWidth={true}
                    select
                    label="time_start"
                    value={filter["time_start"]}
                    onChange={handleTimeStart}
                    helperText="time_start"
                >
                    {rangeDate(times[0], filter["time_stop"]).map(value => <MenuItem key={value + "start"} value={value}>
                        {times[value].getHours() < 10 ? "0" : ""}{times[value].getHours()}:{times[value].getMinutes() < 10 ? "0" : ""}{times[value].getMinutes()}
                    </MenuItem>

                    )}
                </TextField>
                <TextField
                    id="time_stop-select"
                    fullWidth={true}
                    select
                    label="time_stop"
                    value={filter["time_stop"]}
                    onChange={handleTimeStop}
                    helperText="time_stop"
                >
                    {rangeDate(filter["time_start"], times[times.length - 1]).map(value => <MenuItem key={value + "end"} value={value}>
                        {times[value].getHours() < 10 ? "0" : ""}{times[value].getHours()}:{times[value].getMinutes() < 10 ? "0" : ""}{times[value].getMinutes()}
                    </MenuItem>
                    )}
                </TextField>
            </div>
            <div>
                <Box sx={{ m: 1, width: 300 }}>
                    Anzahl Personen
                    <Slider
                        defaultValue={1}
                        getAriaValueText={(v) => '' + v}
                        step={1}
                        marks
                        onChange={handleAmountPerson}
                        min={1}
                        max={10}
                        valueLabelDisplay="auto"
                    />
                </Box>
            </div>
            <div>
                <TextField id="outlined-latitude" label="latitude" variant="outlined" onChange={handleLat} />
                <TextField id="outlined-longitude" label="longitude" variant="outlined" onChange={handleLong} />
                <TextField id="outlined-radius" label="radius" variant="outlined" onChange={handleRadius} />
            </div>
        </Box>
    );
}

export default Filter
