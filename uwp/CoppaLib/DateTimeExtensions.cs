using System;

namespace Just10
{
    /// <summary>
    /// Extensions to the DateTime class to provide some needed functionality
    /// </summary>
    public static class DateTimeExtensions
    {
        private static readonly DateTime EPOCH = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
        private static readonly string DATE_STRING_FORMAT = "yyyymmdd";

        /// <summary>
        /// Convert a unix style timestamp to a DateTime object
        /// </summary>
        /// <param name="millis">Timestamp in milliseconds</param>
        /// <returns>The DateTime value corresponding to the provided timestamp</returns>
        public static DateTime FromMillis (long millis)
        {
            return EPOCH.AddMilliseconds(millis);
        }

        /// <summary>
        /// Convert a yyyyMMdd style time string to a DateTime object
        /// </summary>
        /// <param name="yyyymmdd">date string</param>
        /// <returns>Corresponding DateTime value</returns>
        public static DateTime FromString (string yyyymmdd)
        {
            if (string.IsNullOrEmpty (yyyymmdd))
                throw new ArgumentNullException ("yyyymmdd");

            if (yyyymmdd.Length != DATE_STRING_FORMAT.Length)
                throw new ArgumentException ($"Invalid argument length ({yyyymmdd.Length}). Expected: {DATE_STRING_FORMAT.Length}.");

            return new DateTime (
                Convert.ToInt32 (yyyymmdd.Substring (0, 4)),
                Convert.ToInt32 (yyyymmdd.Substring (4, 2)),
                Convert.ToInt32 (yyyymmdd.Substring (6, 2))
                );
        }

        /// <summary>
        /// Gets the age associated with the birthday being the value of this DateTime object
        /// </summary>
        /// <param name="birthdate">Birth date</param>
        /// <returns>The age, in years</returns>
        public static int GetAge (this DateTime birthdate)
        {
            var today = DateTime.Today;
            bool notReachedBDThisYear = (birthdate.Month > today.Month || (birthdate.Month == today.Month && birthdate.Day > today.Day));
            return today.Year - birthdate.Year - (notReachedBDThisYear ? 1 : 0);
        }

        /// <summary>
        /// Convert this DateTime value to a unix style timestamp
        /// </summary>
        /// <param name="value">DateTime value</param>
        /// <returns>The unix timestamp (millis from epoch)</returns>
        public static long AsMilliseconds (this DateTime value)
        {
            return (value.Ticks - EPOCH.Ticks) / 10000;
        }

        /// <summary>
        /// Convert this DateTime value to a yyyyMMdd string
        /// </summary>
        /// <param name="value">DateTime value</param>
        /// <returns>yyyyMMdd string</returns>
        public static string AsYYYYMMDD (this DateTime value)
        {
            return value.ToString("yyyyMMdd");
        }
    }
}
