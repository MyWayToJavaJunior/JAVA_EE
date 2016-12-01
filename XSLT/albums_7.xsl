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
    
    <xsl:variable name="var1">Albums</xsl:variable>
    
    <xsl:template match="/">
        <html>
            <head>
                <title><xsl:value-of select="$var1"/></title>
            </head>
            <body>
                
                <h1><xsl:value-of select="$var1"/></h1>
                <table border="1">
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Tracks</td>
                        <td>Additional info</td>
                    </tr>
                    <xsl:for-each select="albums/album">
                        <xsl:sort select="name" order="descending"/>
                        <xsl:call-template name="oneAlbum">
                            <xsl:with-param name="pos" select="position()"/>
                        </xsl:call-template>
                    </xsl:for-each>
                </table>
                <h3><xsl:value-of select="$var1"/></h3>
            </body>
        </html>
    </xsl:template>
    
    
    <xsl:template name="oneAlbum">
        <xsl:param name="pos"/>
        <tr>
            <td> 
                ID[<xsl:value-of select="$pos"/>]=<xsl:value-of select="@id"/> 
            </td>
            <td> 
                Name[<xsl:value-of select="$pos"/>]=<xsl:value-of select="name"/> 
            </td>
            <td> 
                Songs[<xsl:value-of select="$pos"/>]:
                <xsl:for-each select="tracks/track">
                    "<xsl:value-of select="name"/>", <xsl:value-of select="duration"/>s <br/>
                </xsl:for-each>
            </td>
            <td>
                Additional info[<xsl:value-of select="$pos"/>]=
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
