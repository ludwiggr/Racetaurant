import { Rating } from '@mui/material';
import Box from '@mui/material/Box';
import MenuItem from '@mui/material/MenuItem';
import Slider from '@mui/material/Slider';
import TextField from '@mui/material/TextField';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import deLocale from 'date-fns/locale/de';
import * as React from 'react';
import { FilterOptions } from '../model/api';
import PriceCategory from '../model/priceCategory';
import FilterCuisine from './filterCuisine';

const Filter: React.FC<{ filter: FilterOptions, setFilter: (filter: FilterOptions) => void }> = ({ filter, setFilter }) => {
    const range = (start: number = 0, end: number = 5) => Array.from({ length: ((end + 1) - start) }, (_v, k) => k + start);

    const [latitude, setLatitude] = React.useState('');
    const [longitude, setLongitude] = React.useState('');
    const [radius, setRadius] = React.useState('');

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

    const handleTimeStart = (value: Date | null) => {
        setFilter({
            ...filter,
            time_start: value === null ? undefined : value
        })
    }

    const handleTimeStop = (value: Date | null) => {
        setFilter({
            ...filter,
            time_stop: value === null ? undefined : value
        })
    }

    const handleAmountPerson = (_event: Event, value: number | number[]) => {
        setFilter({
            ...filter,
            persons: Array.isArray(value) ? value[0] : value
        })
    }

    const handleLong = (event: React.ChangeEvent<HTMLInputElement>) => {
        setLongitude(event.target.value);
        setFilter({
            ...filter,
            longitude: parseFloat(event.target.value)
        });
    }
    const handleLat = (event: React.ChangeEvent<HTMLInputElement>) => {
        setLatitude(event.target.value);
        setFilter({
            ...filter,
            latitude: parseFloat(event.target.value)
        });
    }
    const handleRadius = (event: React.ChangeEvent<HTMLInputElement>) => {
        setRadius(event.target.value);
        setFilter({
            ...filter,
            radius: parseFloat(event.target.value)
        });
    }

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
                <FilterCuisine cuisines={filter["cuisines"] || []} setCuisines={(cuisines) => setFilter({ ...filter, cuisines: cuisines })} />
                <TextField
                    fullWidth={true}
                    id="preis-select"
                    select
                    label="Preis"
                    value={filter["price"] || 0}
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
                    value={filter["rating_min"] || 0}
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
                    value={filter["rating_max"] || 5}
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
                <LocalizationProvider dateAdapter={AdapterDateFns} adapterLocale={deLocale}>
                    <DateTimePicker
                        renderInput={(props) => <TextField {...props} />}
                        label="Start Time"
                        maxDateTime={filter["time_stop"]}
                        value={filter["time_start"] || null}
                        onChange={handleTimeStart}
                        mask="__.__.____ __:__"
                    />
                </LocalizationProvider>
                <LocalizationProvider dateAdapter={AdapterDateFns} adapterLocale={deLocale}>
                    <DateTimePicker
                        renderInput={(props) => <TextField {...props} />}
                        label="Stop Time"
                        minDateTime={filter["time_start"]}
                        value={filter["time_stop"] || null}
                        onChange={handleTimeStop}
                        mask="__.__.____ __:__"
                    />
                </LocalizationProvider>
            </div>
            <div>
                <Box sx={{ m: 1, width: 300 }}>
                    Anzahl Personen
                    <Slider
                        value={filter["persons"] || 1}
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
                <TextField id="outlined-latitude" label="latitude" variant="outlined" value={latitude} onChange={handleLat} onBlur={() => setLatitude(filter["latitude"]?.toString() || '')} />
                <TextField id="outlined-longitude" label="longitude" variant="outlined" value={longitude} onChange={handleLong} onBlur={() => setLongitude(filter["longitude"]?.toString() || '')} />
                <TextField id="outlined-radius" label="radius" variant="outlined" value={radius} onChange={handleRadius} onBlur={() => setRadius(filter["radius"]?.toString() || '')} />
            </div>
        </Box>
    );
}

export default Filter
