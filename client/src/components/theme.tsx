import React, { useContext, useState } from "react";
import { CssBaseline, useMediaQuery } from "@mui/material";
import { createTheme, ThemeOptions, ThemeProvider } from "@mui/material/styles";

type ThemeMode = 'light' | 'dark';
type SelectableThemeMode = ThemeMode | 'preference';
const isSelectableThemeMode = (v: any): v is SelectableThemeMode => ['light', 'dark', 'preference'].includes(v);
type ThemeModeContextType = { selected: SelectableThemeMode, current: ThemeMode, setMode: (mode: SelectableThemeMode) => void };

const ThemeModeContext = React.createContext<ThemeModeContextType>({
    selected: 'preference',
    current: 'light',
    setMode: () => console.warn('Tried to set mode while not in Theme context.')
});

/**
 * A hook for getting and modifying the currently active theme mode
 * @returns the currently active theme mode
 */
export const useThemeMode = () => {
    return useContext(ThemeModeContext);
};

/**
 * Saves a selected theme
 * @param name the name of the theme to save
 * @param mode the SelectableThemeMode to save
 */
const save = (name: string, mode: SelectableThemeMode): void => localStorage.setItem(`theme-${name}`, mode);

/**
 * Loads a previously saved theme
 * @param name the name of the theme to load
 * @param defaultValue the SelectableThemeMode to return if no valid mode was saved
 * @returns the loaded SelectableThemeMode or `defaultValue` if no valid mode was saved
 */
const load = (name: string, defaultValue: SelectableThemeMode = 'preference'): SelectableThemeMode => {
    const val = localStorage.getItem(`theme-${name}`);
    if (isSelectableThemeMode(val))
        return val;
    return defaultValue;
};

/**
 * A consumer component for getting and modifying the currently active theme mdoe
 */
export const ThemeModeConsumer = ThemeModeContext.Consumer;

const Theme = (props: { children: React.ReactNode, theme: ThemeOptions, save?: string }) => {
    const [selectedMode, setSelectedMode] = useState<SelectableThemeMode>(props.save ? load(props.save) : 'preference');
    const preferredMode: ThemeMode = useMediaQuery('(prefers-color-scheme: dark)') ? 'dark' : 'light';
    const mode: ThemeMode = selectedMode === 'preference' ? preferredMode : selectedMode;

    if (props.save)
        save(props.save, selectedMode);

    const theme = createTheme({
        ...props.theme,
        palette: {
            ...props.theme.palette,
            mode: mode,
        }
    });

    return (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <ThemeModeContext.Provider value={{
                selected: selectedMode,
                current: mode,
                setMode: setSelectedMode
            }}>
                {props.children}
            </ThemeModeContext.Provider>
        </ThemeProvider>
    );
}

export default Theme;