<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : albums.xsl
    Created on : 11 Ноябрь 2015 г., 15:40
    Author     : user
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    
    <xsl:variable name="var1">VARIABLE VALUE</xsl:variable>
    <xsl:variable name="var2" select="/albums/album[1]/@id"/>
    <xsl:variable name="var3" select="/albums/album"/>
    
    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="$var1"/>
                </title>
            </head>
            <body>
                
                <h1><xsl:value-of select="$var1"/></h1>
                <h2><xsl:value-of select="$var2"/></h2>
                <h2><xsl:value-of select="$var3"/></h2>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Tracks</td>
                        <td>Additional info</td>
                    </tr>
                    <xsl:apply-templates select="albums"/>

                </table>
                <h3><xsl:value-of select="$var1"/></h3>
            </body>
        </html>
    </xsl:template>
    
    
    <xsl:template match="album">
        <tr>
            <td> 
                <xsl:value-of select="@id"/> 
            </td>
            <td> 
                <xsl:value-of select="name"/> 
            </td>
            <td> 
                <xsl:for-each select="tracks/track">
                    "<xsl:value-of select="name"/>", <xsl:value-of select="duration"/>seconds <br/>
                </xsl:for-each>
            </td>
            <td>
                <xsl:choose>
                    <xsl:when test="year &gt;= 2000">
                        NEW!!!
                    </xsl:when>
                    <xsl:when test="year &lt; 2000 and year &gt;= 1990">
                        Relatively old
                    </xsl:when>
                    <xsl:otherwise>
                        Old
                    </xsl:otherwise>
                </xsl:choose>
            </td>
        </tr>
    </xsl:template>


</xsl:stylesheet>
