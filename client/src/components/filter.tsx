import { Box, Button, InputBaseProps, Rating, Slider, TextField, ToggleButton, ToggleButtonGroup } from '@mui/material';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import deLocale from 'date-fns/locale/de';
import * as React from 'react';
import { FilterOptions } from '../model/api';
import styles from '../styles/filter.module.css';
import FilterCuisine from './filterCuisine';
import PriceCategory from './priceCategory';

/**
 * Creates {@link CSSProperties} that make the component occupy the space with the name `name`
 * @param name name of the grid space to occupy
 * @returns an object that can be passed to a components style so that the component occupies the selected space
 */
const gridItem = (name: string): React.CSSProperties => ({ gridArea: name });

const Filter: React.FC<{ filter: FilterOptions, setFilter: (filter: FilterOptions) => void, onClose?: VoidFunction }> = ({ filter, setFilter, onClose }) => {

    /**
     * Returns the value of a filter or a default value if the filter is not set
     * @param name name of the filter that is displayed
     * @param defaultValue the default value that is returned when the filter is not set. Not `null`, so that `null` will never be returned.
     * @returns the value of the given filter or `defaultValue` if the filter is not set
     */
    function withDefault<K extends keyof FilterOptions>(name: K, defaultValue: Exclude<FilterOptions[K], undefined>): Exclude<FilterOptions[K], undefined>;
    /**
     * Returns the value of a filter or `null` if the filter is not set
     * @param name name of the filter that is displayed
     * @returns the value of the given filter or `null` if the filter is not set
     */
    function withDefault<K extends keyof FilterOptions>(name: K): Exclude<FilterOptions[K], undefined> | null;
    /**
     * Returns the value of a filter or a default value if the filter is not set
     * @param name name of the filter that is displayed
     * @param defaultValue the default value that is returned when the filter is not set. `null` by default.
     * @returns the value of the given filter or `defaultValue` if the filter is not set
     */
    function withDefault<K extends keyof FilterOptions>(name: K, defaultValue: Exclude<FilterOptions[K], undefined> | null): Exclude<FilterOptions[K], undefined> | null;
    function withDefault<K extends keyof FilterOptions>(name: K, defaultValue: Exclude<FilterOptions[K], undefined> | null = null): Exclude<FilterOptions[K], undefined> | null {
        const value = filter[name];
        if (value === undefined)
            return defaultValue;
        return (value as Exclude<FilterOptions[K], undefined>);
    }

    /**
     * Helper function for TextFields setting numbers in filter
     * @param name name of the filter that is changed
     * @param parse the function used to parse a string into a number
     * @returns props for a TextField containing the value, a change and a blur callback
     */
    const setNumber = (name: keyof FilterOptions, parse = parseFloat): { value: string, onChange: InputBaseProps['onChange'], onBlur: InputBaseProps['onBlur'] } => {
        const [value, setValue] = React.useState(filter[name]?.toString() || '');
        return {
            value: value,
            onChange: (event: React.ChangeEvent<HTMLInputElement>) => {
                const eventValue = event.target.value.replace(',', '.');
                setValue(eventValue);
                let numberValue: number | undefined = parse(eventValue);
                if (isNaN(numberValue))
                    numberValue = undefined;
                setFilter({
                    ...filter,
                    [name]: numberValue
                });
            },
            onBlur: () => setValue(filter[name]?.toString() || ''),
        }
    };

    return (
        <Box component="form" noValidate autoComplete="off" className={styles.container}>
            {/* Cusisines */}
            <FilterCuisine style={gridItem('cuisine')} cuisines={filter["cuisines"] || []} setCuisines={(cuisines) => setFilter({ ...filter, cuisines: cuisines })} />
            {/* Price category */}
            <ToggleButtonGroup fullWidth style={gridItem('price')} color="primary" value={withDefault('price')} exclusive onChange={(_, value) => setFilter({ ...filter, price: value != null ? value : undefined })}>
                <ToggleButton value={0}><PriceCategory category={0} /></ToggleButton>
                <ToggleButton value={1}><PriceCategory category={1} /></ToggleButton>
                <ToggleButton value={2}><PriceCategory category={2} /></ToggleButton>
            </ToggleButtonGroup>
            {/* Rating */}
            <div className={styles['rating-container']} style={gridItem('rating')}>
                <Rating precision={0.5} value={withDefault('rating_min', 0)} readOnly />
                <Slider
                    value={[withDefault('rating_min', 0), withDefault('rating_max', 5)]}
                    onChange={(_, value) => Array.isArray(value) && value.length === 2 && setFilter({ ...filter, rating_min: value[0], rating_max: value[1] })}
                    step={0.5}
                    marks
                    min={0}
                    max={5}
                    valueLabelDisplay="off"
                />
                <Rating precision={0.5} value={withDefault('rating_max', 5)} readOnly />
            </div>
            {/* Start time */}
            <LocalizationProvider dateAdapter={AdapterDateFns} adapterLocale={deLocale}>
                <DateTimePicker
                    renderInput={(props) => <TextField fullWidth style={gridItem('from')} {...props} />}
                    label="Start Time"
                    minDateTime={new Date()}
                    maxDateTime={withDefault('time_stop')}
                    value={withDefault('time_start')}
                    onChange={value => setFilter({ ...filter, time_start: value === null ? undefined : value })}
                    mask="__.__.____ __:__"
                />
            </LocalizationProvider>
            {/* End time */}
            <LocalizationProvider dateAdapter={AdapterDateFns} adapterLocale={deLocale}>
                <DateTimePicker
                    renderInput={(props) => <TextField fullWidth style={gridItem('to')} {...props} />}
                    label="Stop Time"
                    minDateTime={withDefault('time_start', new Date())}
                    value={withDefault('time_stop')}
                    onChange={value => setFilter({ ...filter, time_stop: value === null ? undefined : value })}
                    mask="__.__.____ __:__"
                />
            </LocalizationProvider>
            {/* Number of persons */}
            <TextField fullWidth style={gridItem('persons')} label="Personen" variant="outlined" {...setNumber('persons', parseInt)} />
            {/* Location Latitude */}
            <TextField fullWidth style={gridItem('latitude')} label="Latitude" variant="outlined" {...setNumber('latitude')} />
            {/* Location longitude */}
            <TextField fullWidth style={gridItem('longitude')} label="Longitude" variant="outlined"  {...setNumber('longitude')} />
            {/* Location radius */}
            <TextField fullWidth style={gridItem('radius')} label="Radius" variant="outlined" {...setNumber('radius')} />
            {/* Submit button */}
            <Button style={gridItem('button')} variant="contained" color="primary" onClick={onClose}>Filter anwenden</Button>
        </Box>
    );
}

export default Filter;
